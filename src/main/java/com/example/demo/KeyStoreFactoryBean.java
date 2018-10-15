package com.example.demo;

import java.security.KeyStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class KeyStoreFactoryBean implements FactoryBean<KeyStore>, InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(KeyStoreFactoryBean.class);
    private final Resource location;
    private final char[] password;
    private final String type;
    private KeyStore keyStore;

    public KeyStoreFactoryBean(Resource location, String password) {
        this(location, password, KeyStore.getDefaultType());
    }

    public KeyStoreFactoryBean(Resource location, String password, String type) {
        Assert.notNull(location, "Location must not be null");
        Assert.hasLength(password, "Password must not be empty");
        Assert.hasLength(type, "Type must not be empty");
        this.location = location;
        this.password = password.toCharArray();
        this.type = type.trim();
    }

    @Override
    public KeyStore getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return KeyStore.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Location: {}", location);
        LOG.info("Password: {}", password);
        LOG.info("Type: {}", type);
    }
}
