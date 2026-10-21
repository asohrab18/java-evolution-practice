/**Sealed Classes, introduced by JEP 409, allow developers to restrict which classes or interfaces 
 * can extend or implement a particular class or interface. 
 * This provides better control over inheritance hierarchies.
* Uses the sealed keyword to restrict inheritance.
* Uses permits to specify allowed subclasses.
* Permitted subclasses can be final, sealed, or non-sealed.*/

package com.learning.sealed.classes;

sealed class Vehicle permits Car, Bike {

	// Here, only Car and Bike are allowed to directly extend the Vehicle class.
}
