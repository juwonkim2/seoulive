package org.zerock.seoulive.board.course.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CourseCommand {

    public abstract void execute(HttpServletRequest req, HttpServletResponse res);

} // end interface
