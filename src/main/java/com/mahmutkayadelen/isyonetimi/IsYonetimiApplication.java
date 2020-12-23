package com.mahmutkayadelen.isyonetimi;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;


@SpringBootApplication
public class IsYonetimiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsYonetimiApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean responnsePopulator() {
         //proje ayağa kalkınca gidip json dosyamızdaki kayıtları update eder, diğer yöntem ise sql dosyası oluşturup bu şekilde çağırmak öyle de çalışır.
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
       //her startta burayı çalıştıracağından burdakı satırı yoruma attım
        //factory.setResources(new Resource[]{new ClassPathResource("testData.json")});
        return factory;
    }

}
