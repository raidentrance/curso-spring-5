/**
 * 
 */
package com.devs4j.spring.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devs4j.spring.dao.AuthorDao;
import com.devs4j.spring.models.author.Author;

/**
 * @author raidentrance
 *
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

	/**
	 * Caso 1: Ejecutando MANDATORY desde NOT_SUPPORTED -
	 * (IllegalTransactionStateException:) Caso 2: Ejecutando MANDATORY desde
	 * REQUIERED - Funciona correctamente Caso 3: Ejecutando NEVER desde
	 * REQUIRED - IllegalTransactionStateException Caso 4: Ejecutando
	 * NOT_SUPPORTED desde RQUIRED - (suspende la transacción pero no falla)
	 * Caso 5: Ejecutando REQUIRES_NEW desde REQUIRED - Funciona correctamente
	 * Caso 6: Ejecutando SUPPORTS desde REQUIRED -Funciona correctamente caso
	 * 7: NESTED es utilizado para transacciones de tipo batch
	 * 
	 * @param idAuthor
	 * @param authorName
	 * @param twitter
	 * @throws SQLException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE, timeout = 12, readOnly = true)
	public void create(Integer idAuthor, String authorName, String twitter) throws SQLException {
		Author author = new Author(idAuthor, authorName, twitter);
		authorDao.create(author);
		/**
		 * Uncomment to check the transaction attributes on detail
		 */
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}
}
