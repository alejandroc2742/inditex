package com.inditex.prices;

import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class ArchuUnitTest {

    private final JavaClasses importedClasses = new ClassFileImporter().importPackages("com.inditex.prices.infrastructure");

    @Test
    void servicesShouldResideInServicePackage() {
        ArchRuleDefinition.classes()
            .that().resideInAPackage("..service..")
            .should().beAnnotatedWith(Service.class)
            .allowEmptyShould(true) 
            .check(importedClasses);
    }

    @Test
    void repositoriesShouldResideInRepositoryPackage() {
        ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..")
            .should().beAnnotatedWith(Repository.class)
            .allowEmptyShould(true) 
            .check(importedClasses);
    }

    @Test
    void mappersShouldResideInMapperPackage() {
        ArchRuleDefinition.classes()
    .that().resideInAPackage("..mapper..")
    .and().haveSimpleNameNotEndingWith("Impl")
    .and().haveSimpleNameNotEndingWith("Test")
    .should().beInterfaces()
    .andShould().beAnnotatedWith(Mapper.class)
    .check(importedClasses);

    }
}