package com.inditex.prices.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

class ArchitectureTest {

    @Test
    void servicesShouldNotDependOnControllers() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.inditex.prices");

        ArchRule rule = classes()
            .that().resideInAPackage("com.inditex.prices.application.service..")
            .should().onlyDependOnClassesThat()
            .resideOutsideOfPackage("com.inditex.prices.infrastructure.controller..");

        rule.check(importedClasses);
    }

    @Test
    void controllersShouldDependOnServices() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.inditex.prices");

        ArchRule rule = classes()
            .that().resideInAPackage("..infrastructure.adapter.in.rest..")
            .should().dependOnClassesThat()
            .resideInAPackage("..application.service..");

        rule.check(importedClasses);
    }

    @Test
    void entitiesShouldBePublic() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.inditex.prices");

        ArchRule rule = classes()
            .that().resideInAPackage("..infrastructure.adapter.out.persistence..")
            .should().bePublic();

        rule.check(importedClasses);
    }
    
    @Test
    public void servicesShouldBeAnnotatedWithService() {
        var importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.inditex.prices");

        ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("Service")
            .should().beAnnotatedWith(Service.class)
            .check(importedClasses);
    }
}
