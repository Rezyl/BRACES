package cz.uhk.braces.service;

import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.model.register.RegisterItem;

import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
public interface RegisterItemService extends CRUDService<RegisterItem> {

	List<RegisterItem> getByRegisterCode(String registerCode);
	List<RegisterItem> getByRegister(Register register);

	RegisterItem getByRegisterItemCode(String registerItemCode);
}
