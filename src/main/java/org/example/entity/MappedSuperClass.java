package org.example.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MappedSuperClass {

    /*

    Mapped Superclass - это класс, от которого наследуются Entity,
    он может содержать анотации JPA, однако сам такой класс не является Entity,
    ему не обязательно выполнять все требования установленные для Entity (например, он может не содержать первичного ключа).
    Такой класс не может использоваться в операциях EntityManager или Query. Такой класс должен быть отмечен аннотацией MappedSuperclass
    или описан в xml файле.
    Создание такого класса-предка оправдано тем, что мы заранее определяем ряд свойств и методов, которые должны быть определены в сущностях.
    Использование такого подхода позволило сократить количество кода
    * */
}
