package com.learning.functionalInterfaces.customized;

import com.learning.model.Student;

public interface StudentProvider {

	Student find(String name, int age);
}
