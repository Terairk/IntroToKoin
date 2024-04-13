package org.example

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

data class User(val name : String)

interface UserRepository {
    fun findUser(name: String): User?
    fun addUsers(users: List<User>)
}

class UserRepositoryImpl : UserRepository {
    private val _users = mutableListOf<User>()

    override fun findUser(name: String): User? {
        return _users.find { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }
}

class UserService(private val userRepository: UserRepository) {
    fun getDefaultUser(): User =
        userRepository.findUser("default") ?: error("Can't find default user")
    fun addUser(user: User) {
        userRepository.addUsers(listOf(user))
    }
}

val userModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::UserService)
}

class UserApplication : KoinComponent {
    private val userService: UserService by inject()
    fun sayHello() {
        val user = userService.getDefaultUser()
        val message = "Hello, ${user.name}!"
        println(message)
    }
}