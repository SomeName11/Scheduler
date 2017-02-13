package main.java.scheduler.validator;

import main.java.scheduler.model.Student;
import main.java.scheduler.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

    @Autowired
    private StudentService studentService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (student.getLogin().length() < 8 || student.getLogin().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (studentService.findByLogin(student.getLogin()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (student.getPassword().length() < 8 || student.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!student.getConfirmPassword().equals(student.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
