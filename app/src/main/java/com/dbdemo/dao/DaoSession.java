package com.dbdemo.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.dbdemo.bean.Classes;
import com.dbdemo.bean.JoinTeacherToStudent;
import com.dbdemo.bean.Student;
import com.dbdemo.bean.Teacher;

import com.dbdemo.dao.ClassesDao;
import com.dbdemo.dao.JoinTeacherToStudentDao;
import com.dbdemo.dao.StudentDao;
import com.dbdemo.dao.TeacherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig classesDaoConfig;
    private final DaoConfig joinTeacherToStudentDaoConfig;
    private final DaoConfig studentDaoConfig;
    private final DaoConfig teacherDaoConfig;

    private final ClassesDao classesDao;
    private final JoinTeacherToStudentDao joinTeacherToStudentDao;
    private final StudentDao studentDao;
    private final TeacherDao teacherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        classesDaoConfig = daoConfigMap.get(ClassesDao.class).clone();
        classesDaoConfig.initIdentityScope(type);

        joinTeacherToStudentDaoConfig = daoConfigMap.get(JoinTeacherToStudentDao.class).clone();
        joinTeacherToStudentDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        teacherDaoConfig = daoConfigMap.get(TeacherDao.class).clone();
        teacherDaoConfig.initIdentityScope(type);

        classesDao = new ClassesDao(classesDaoConfig, this);
        joinTeacherToStudentDao = new JoinTeacherToStudentDao(joinTeacherToStudentDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);
        teacherDao = new TeacherDao(teacherDaoConfig, this);

        registerDao(Classes.class, classesDao);
        registerDao(JoinTeacherToStudent.class, joinTeacherToStudentDao);
        registerDao(Student.class, studentDao);
        registerDao(Teacher.class, teacherDao);
    }
    
    public void clear() {
        classesDaoConfig.clearIdentityScope();
        joinTeacherToStudentDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
        teacherDaoConfig.clearIdentityScope();
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public JoinTeacherToStudentDao getJoinTeacherToStudentDao() {
        return joinTeacherToStudentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

}