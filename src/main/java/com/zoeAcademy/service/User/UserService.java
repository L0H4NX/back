package com.zoeAcademy.service.User;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.User;
import com.zoeAcademy.repository.User.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GenericReturn<User> verifyUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null) {
            return new GenericReturn<>(true, "Usuário ou senha inválidos", null);
        }

        return new GenericReturn<>(true, "Usuário encontrado com sucesso", user);
    }

    public GenericReturn<?> getUser(String email) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return new GenericReturn<>(true, "Usuário não encontrado", null);
        }

        return new GenericReturn<>(true, "Usuário encontrado com sucesso", userRepository.findByEmail(email));
    }

    public GenericReturn<?> findUserById(Long id) {
        System.out.println(id);

        User user = userRepository.findById(id).get();

        if (user == null) {
            return new GenericReturn<>(true, "Usuário não encontrado", null);
        }

        return new GenericReturn<>(true, "Usuário encontrado com sucesso", userRepository.findById(id));
    }

    public GenericReturn<?> createUser(User user) {
        return new GenericReturn<>(true, "Usário salvo com sucesso", userRepository.save(user));
    }

    public GenericReturn<?> updateUser(User user) {
        return new GenericReturn<>(true, "Usuário atualizado com sucesso", userRepository.save(user));
    }

    public GenericReturn<Void> deleteUser(Long id) {

        String userName = userRepository.findById(id).get().getName();

        userRepository.deleteById(id);

        return new GenericReturn<>(true, "Usário " + userName + " excluído com sucesso", null);
    }
}
