package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.LinkDAO;
import org.hov.model.OTPLink;
import org.hov.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{
	@Autowired
	LinkDAO linkDAO;
	
	@Override
	public boolean generateLink(OTPLink link) {
		UUID linkKey = null;
		linkKey = linkDAO.createLink(link);
		if(linkKey!=null) {
			//Email Logic Here
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean regenerateLink(UUID linkId) {
		OTPLink link = getLinkById(linkId);		//copy Old Link Data
		link.setLinkkey(null);
		if(linkDAO.createLink(link)!=null) {    //Save Same Link with different Id
			return linkDAO.removeLink(linkId);	//Remove Old Link
		}
		return false;
	}
	
	@Override
	public boolean updateLink(OTPLink link) {
		return linkDAO.updateLink(link);
	}
	
	@Override
	public boolean removeLink(UUID linkId) {
		return linkDAO.removeLink(linkId);
	}

	@Override
	public OTPLink getLinkById(UUID linkId) {
		return linkDAO.getLinkById(linkId);
	}
}