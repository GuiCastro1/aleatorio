package br.com.starttech.cadastro_user.cadastro_user.repository;

import br.com.starttech.cadastro_user.cadastro_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCadastro extends JpaRepository <User, Integer> {
}
