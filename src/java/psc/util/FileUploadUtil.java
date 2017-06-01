/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author AksHaY
 */
public class FileUploadUtil {

    public static File upload(HttpServletRequest request, HttpServletResponse response, String directory) {

        File file = null;
        int maxFileSize = 100000 * 1024;
        int maxMemSize = 100000 * 1024;
        String contentType = request.getContentType();
        if ((contentType.contains("multipart/form-data"))) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File(directory));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);

            try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        file = new File(directory + "\\" + fi.getName());
                        fi.write(file);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return file;
    }
}
