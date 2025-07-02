package com.mertalptekin.springrestapidemo.starter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Not: Uygulama içerisinde bir çok yerde servislerin içerisinde entity dto çevirme gibi bir durum olacağından uygulama genelinde ModelMapper servici bir bean haline getirdik. Her servis buradaki Bean Instance kullanıcaktır.
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
