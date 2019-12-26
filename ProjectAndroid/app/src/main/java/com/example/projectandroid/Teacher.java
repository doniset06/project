package com.example.projectandroid;

public class
Teacher {

        String id;
        String name;
        String password;
        String subject;

        public  Teacher(){

        }
        public Teacher( String id,String name ,String subject) {

            this.setId(id);
            this.setName(name);

            this.setSubject(subject);
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {

            this.id = id;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }

        public String getPassword() {

            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public String getSubject() {

            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }


