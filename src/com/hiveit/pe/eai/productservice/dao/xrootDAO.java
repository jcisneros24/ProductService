package com.hiveit.pe.eai.productservice.dao;

import java.sql.SQLException;

import com.hiveit.pe.eai.productservice.bean.ProductBeanResponse;
import com.hiveit.pe.eai.productservice.bean.ProductRequestBean;

public interface xrootDAO {
	ProductBeanResponse updateProduct(ProductRequestBean request) throws SQLException;
	ProductBeanResponse deleteProduct(ProductRequestBean request) throws SQLException;
}
