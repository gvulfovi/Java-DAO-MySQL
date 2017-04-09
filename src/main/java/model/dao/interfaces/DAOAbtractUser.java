package model.dao.interfaces;

import model.dao.entity.User;

/**
 * Created by lonely on 21.06.16.
 */
public interface DAOAbtractUser{
	int register( User user );
	User getUserByUsername( String username );
}
