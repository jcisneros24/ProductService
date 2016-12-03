package com.hiveit.pe.eai.productservice.dao;

import com.hiveit.pe.eai.productservice.bean.ProductBeanRequest;
import com.hiveit.pe.eai.productservice.bean.ProductBeanResponse;
import com.hiveit.pe.eai.productservice.exception.DBException;

public interface XrootDao {
	ProductBeanResponse updateProduct(ProductBeanRequest request) throws DBException;
	ProductBeanResponse deleteProduct(ProductBeanRequest request) throws DBException;
}
