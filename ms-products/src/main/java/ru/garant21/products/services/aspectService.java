package ru.garant21.products.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.garant21.products.dtos.ProductDto;

@Aspect
@Component
public class aspectService {

    @Before("execution(public * ru.garant21.products.controllers.ProductController.*(..))")
    public void beforeFindProductById(JoinPoint thisJoinPoint) {
        Object[] signatureArgs = thisJoinPoint.getArgs();
        if (signatureArgs.length != 0) {
            for (Object signatureArg : signatureArgs) {
                System.out.println("Аргумент: " + signatureArg);
            }
        } else
            System.out.println("Аргументов нет");
    }
}
