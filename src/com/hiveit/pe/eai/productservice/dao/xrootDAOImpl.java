package com.hiveit.pe.eai.productservice.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.hiveit.pe.eai.productservice.ConnectionDB;
import com.hiveit.pe.eai.productservice.bean.ProductBeanResponse;
import com.hiveit.pe.eai.productservice.bean.ProductRequestBean;
public class xrootDAOImpl implements xrootDAO {
	ConnectionDB cn;
	public xrootDAOImpl() {
		cn = new ConnectionDB();
	}

	@Override
	public ProductBeanResponse updateProduct(ProductRequestBean request) throws SQLException {
		ProductBeanResponse response = null;
		Connection accessDB = null;
		CallableStatement cs = null;
		try {
			response = new ProductBeanResponse();
			accessDB = cn.getConnection();
			cs = accessDB.prepareCall("call SP_UPDATE_ARTICULOS(?,?)");
			cs.setString(1, request.getReferenceOld());
			cs.setString(2, request.getReferenceNew());
			int numFafectadas = cs.executeUpdate();
			if(numFafectadas==0){
				response.setMsgRpta("Actualizacion del producto exitosa");;
			}
		} catch (SQLException e) {
			response.setMsgRpta(e.getMessage());
		}
		return response;
	}

	@Override
	public ProductBeanResponse deleteProduct(ProductRequestBean request) {
		ProductBeanResponse response = null;
		Connection accessDB = null;
		CallableStatement cs = null;
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
