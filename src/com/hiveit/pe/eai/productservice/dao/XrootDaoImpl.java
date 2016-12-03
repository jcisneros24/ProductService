package com.hiveit.pe.eai.productservice.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.hiveit.pe.eai.productservice.ConnectionDB;
import com.hiveit.pe.eai.productservice.bean.ProductBeanRequest;
import com.hiveit.pe.eai.productservice.bean.ProductBeanResponse;
import com.hiveit.pe.eai.productservice.exception.DBException;
public class XrootDaoImpl implements XrootDao {
	ConnectionDB cn;
	public XrootDaoImpl() {
		cn = new ConnectionDB();
	}

	@Override
	public ProductBeanResponse updateProduct(ProductBeanRequest request) throws DBException {
		ProductBeanResponse response = null;
		Connection accessDB = null;
		CallableStatement cs = null;
		try {
			response = new ProductBeanResponse();
			accessDB = cn.getConnection();
			cs = accessDB.prepareCall("call SP_UPDATE_ARTICULOS(?,?)");
			cs.setString(1, request.getCodArtiOld());
			cs.setString(2, request.getCodArtiNew());
			int numFafectadas = cs.executeUpdate();
			if(numFafectadas==0){
				response.setCodRpta("0");
				response.setMsgRpta("Se actualizo correctamente el producto.");;
			}
		} catch (SQLException e) {
			response.setCodRpta(e.getLocalizedMessage());
			response.setMsgRpta(e.getMessage());
			throw new DBException( response.getCodRpta(), response.getMsgRpta());
		}
		return response;
	}

	@Override
	public ProductBeanResponse deleteProduct(ProductBeanRequest request) throws DBException {
		ProductBeanResponse response = null;
		Connection accessDB = null;
		//CallableStatement cs = null;
		try {
			response = new ProductBeanResponse();
			accessDB = cn.getConnection();
			accessDB.prepareCall("");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

}
