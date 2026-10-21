package com.learning.sealed.classes;

sealed class Vehicle permits Car, Bike {

	// Here, only Car and Bike are allowed to directly extend the Vehicle class.
}
