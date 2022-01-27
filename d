[33mcommit 412509a52834b9499f7254b382f8b92695933f36[m[33m ([m[1;36mHEAD -> [m[1;32mbackend-config-error[m[33m, [m[1;31morigin/backend_relation_error[m[33m, [m[1;31morigin/backend[m[33m, [m[1;32mbackend_relation_error[m[33m, [m[1;32mbackend[m[33m)[m
Author: qlanduril <berkan.sivrikaya@ug.bilkent.edu.tr>
Date:   Thu Nov 25 01:41:29 2021 +0300

    fixed colum couldnt find error
    
    the sloution was adding forreginkeys by mentioning  th onetoone and onetomany relations

[1mdiff --git a/bpm/src/main/java/com/api/bpm/model/DormInfo.java b/bpm/src/main/java/com/api/bpm/model/DormInfo.java[m
[1mindex d5dc22b..2facd30 100644[m
[1m--- a/bpm/src/main/java/com/api/bpm/model/DormInfo.java[m
[1m+++ b/bpm/src/main/java/com/api/bpm/model/DormInfo.java[m
[36m@@ -1,7 +1,15 @@[m
 package com.api.bpm.model;[m
 [m
[32m+[m[32mimport javax.persistence.*;[m
[32m+[m
[32m+[m[32m@Entity[m
 public class DormInfo {[m
 [m
[32m+[m[32m    @Id[m
[32m+[m[32m    @GeneratedValue(strategy = GenerationType.IDENTITY)[m
[32m+[m[32m    @Column(name = "id")[m
[32m+[m[32m    private int id;[m
[32m+[m
     int dormNo;[m
     int floor;[m
     char label;[m
[1mdiff --git a/bpm/src/main/java/com/api/bpm/model/entities/AbroadVaccineCard.java b/bpm/src/main/java/com/api/bpm/model/entities/AbroadVaccineCard.java[m
[1mindex 27e88c3..ae0bac6 100644[m
[1m--- a/bpm/src/main/java/com/api/bpm/model/entities/AbroadVaccineCard.java[m
[1m+++ b/bpm/src/main/java/com/api/bpm/model/entities/AbroadVaccineCard.java[m
[36m@@ -7,10 +7,12 @@[m [mimport javax.persistence.*;[m
 import com.api.bpm.model.VaccineCard;[m
 [m
 import lombok.Data;[m
[32m+[m[32mimport lombok.EqualsAndHashCode;[m
 [m
 import java.io.File;[m
 [m
 @Data[m
[32m+[m[32m@EqualsAndHashCode(callSuper=false)[m
 @Entity[m
 @Table(name = "AbroadVaccineCard")[m
 public class AbroadVaccineCard extends VaccineCard {[m
[1mdiff --git a/bpm/src/main/java/com/api/bpm/model/entities/Course.java b/bpm/src/main/java/com/api/bpm/model/entities/Course.java[m
[1mindex 614fda9..8091b39 100644[m
[1m--- a/bpm/src/main/java/com/api/bpm/model/entities/Course.java[m
[1m+++ b/bpm/src/main/java/com/api/bpm/model/entities/Course.java[m
[36m@@ -20,13 +20,18 @@[m [mpublic class Course {[m
     @Column(name = "id")[m
     private int id;[m
 [m
[31m-    @Column(name= "CourseInfo")[m
[32m+[m[32m    @OneToOne(targetEntity = CourseInfo.class, cascade = CascadeType.ALL )[m
[32m+[m[32m    @JoinColumn(name = "courseIfo_id", referencedColumnName = "id")[m
     CourseInfo courseInfo;[m
 [m
     ArrayList<Lecture> lectures;[m
 [m
[32m+[m[32m    @OneToOne(targetEntity = Instructor.class, cascade = CascadeType.ALL )[m
[32m+[m[32m    @JoinColumn(name = "instructor_id", referencedColumnName = "id")[m
     Instructor instructor;[m
 [m
[32m+[m[32m    @ManyToOne(targetEntity = Instructor.class, cascade = CascadeType.ALL )[m
[32m+[m[32m    @JoinColumn(name = "students_id", referencedColumnName = "id")[m
     List<Student> students;[m
 [m
 }[m
[1mdiff --git a/bpm/src/main/java/com/api/bpm/model/entities/Student.java b/bpm/src/main/java/com/api/bpm/model/entities/Student.java[m
[1mindex 81a3a09..dbe88bf 100644[m
[1m--- a/bpm/src/main/java/com/api/bpm/model/entities/Student.java[m
[1m+++ b/bpm/src/main/java/com/api/bpm/model/entities/Student.java[m
[36m@@ -22,8 +22,14 @@[m [mpublic class Student extends EndUser{[m
     @Getter(value=AccessLevel.NONE)[m
     private int id;[m
 [m
[32m+[m[32m    @OneToOne(targetEntity = DormInfo.class, cascade = CascadeType.ALL )[m
[32m+[m[32m    @JoinColumn(name = "dormInfo_id", referencedColumnName = "id")[m
     DormInfo dormInfo;[m
 [m
[32m+[m[32m    @ManyToMany()[m
[32m+[m[32m    @JoinTable([m
[32m+[m[32m    name = "nearby_student",[m[41m [m
[32m+[m[32m    joinColumns = @JoinColumn(name = "student_id"))[m
     List<Student> nearbyStudents;[m
 [m
 [m
[1mdiff --git a/bpm/src/main/resources/application.properties b/bpm/src/main/resources/application.properties[m
[1mindex 4235c45..0ff1c0d 100644[m
[1m--- a/bpm/src/main/resources/application.properties[m
[1m+++ b/bpm/src/main/resources/application.properties[m
[36m@@ -5,6 +5,6 @@[m [mspring.datasource.username=postgres[m
 spring.datasource.password=12345678[m
 spring.jpa.show-sql=true[m
 spring.jpa.generate-ddl=true[m
[31m-#spring.jpa.hibernate.ddl-auto= update[m
[31m-spring.jpa.hibernate.ddl-auto=create-drop  [m
[32m+[m[32mspring.jpa.hibernate.ddl-auto= update[m
[32m+[m[32m#spring.jpa.hibernate.ddl-auto=create-drop[m[41m  [m
 spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true[m
