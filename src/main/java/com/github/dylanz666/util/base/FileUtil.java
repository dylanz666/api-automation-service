package com.github.dylanz666.util.base;

import com.github.dylanz666.util.senior.EnvUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
@Service
public class FileUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * read request body from file
     *
     * @param env:      run time env
     * @param fileName: body file name in body/*
     */
    public String readRequestBodyFromFile(String env, String fileName) throws Exception {
        if (null == env) {
            throw new Exception("Null env name!");
        }
        if (null == fileName) {
            throw new Exception("Null file name!");
        }
        env = EnvUtil.convertAll(env);
        File file = getResourceFile("body/" + env + "/" + fileName + ".json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    /**
     * read xml request body from file
     *
     * @param env:      run time env
     * @param fileName: xml body file name in body/*
     */
    public String readXmlBodyFromFile(String env, String fileName) throws Exception {
        if (null == env) {
            throw new Exception("Null env name!");
        }
        if (null == fileName) {
            throw new Exception("Null file name!");
        }
        env = EnvUtil.convertAll(env);
        File file = getResourceFile("body/" + env + "/" + fileName + ".xml");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    /**
     * read config info from file
     *
     * @param env: env file name in config/*
     */
    public String readConfigInfoFromFile(String env) throws Exception {
        if (null == env) {
            throw new Exception("Null env name!");
        }
        env = EnvUtil.convertAll(env);
        File file = getResourceFile("config/" + env + ".json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    /**
     * read test data from file
     *
     * @param env:      run time env
     * @param fileName: test data file name in data/cm/* or data/qp/* or data/pr/*
     */
    public String readTestDataFromFile(String env, String fileName) throws Exception {
        if (null == fileName) {
            throw new Exception("Null file name!");
        }
        env = EnvUtil.convertAll(env);
        File file = getResourceFile("data/" + env + "/" + fileName + ".json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    /**
     * read sql from file
     *
     * @param fileName: table name in resources/sql/*
     */
    public String readSqlFromFile(String fileName) throws Exception {
        if (null == fileName) {
            throw new Exception("Null file name!");
        }
        File file = getResourceFile("sql/" + fileName + ".json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    /**
     * get file by file name
     *
     * @param fileName: file name which in resources/*
     */
    public File getResourceFile(String fileName) throws Exception {
        if (null == fileName) {
            throw new Exception("Null file name!");
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (null == resource) {
            throw new Exception("File not found! Details:" + fileName);
        }
        return new File(resource.getFile());
    }

    /**
     * copy folder
     *
     * @param source:source folder path
     * @param target:target folder path
     */
    public void copyFolder(String source, String target, Boolean createFolderWhenNotExisted) throws Exception {
        File sourceFile = new File(source);
        if (!sourceFile.isDirectory()) {
            System.out.println("Invalid source folder,stop copy folder!");
            return;
        }
        File targetFile = new File(target);
        if (!targetFile.isDirectory() && !createFolderWhenNotExisted) {
            throw new Exception("Invalid target folder:" + target);
        }
        if (!targetFile.isDirectory()) {
            targetFile.mkdir();
        }

        File[] sourceFiles = sourceFile.listFiles();
        for (File file : sourceFiles) {
            File file1 = new File(targetFile.getAbsolutePath() + File.separator + sourceFile.getName());
            if (file.isFile()) {//if it is a file
                if (!file1.exists()) {//create target folder when not exist
                    file1.mkdirs();
                }
                File targetFile1 = new File(file1.getAbsolutePath() + File.separator + file.getName());
                copyFile(file, targetFile1);
                continue;
            }
            if (file.isDirectory()) {//if it is a folder
                String dir1 = file.getAbsolutePath();
                String dir2 = file1.getAbsolutePath();
                copyFolder(dir1, dir2, true);
            }
        }
    }

    /**
     * copy file with java file
     *
     * @param sourceFile:source file
     * @param targetFile:target file
     */
    public void copyFile(File sourceFile, File targetFile) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int i = -1;
        byte[] bt = new byte[1024 * 2];
        while ((i = bis.read(bt)) != -1) {
            bos.write(bt, 0, i);
        }
        bis.close();
        bos.close();
    }

    /**
     * copy file with file com.ehi.bo.path
     *
     * @param sourceFilePath:source file path
     * @param sourceFilePath:target file path
     */
    public void copyFile(String sourceFilePath, String targetFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.isFile() || !sourceFile.exists()) {
            throw new Exception("Invalid source file:" + sourceFile.getAbsolutePath());
        }
        File targetFile = new File(targetFilePath);
        if (!targetFile.isFile() || !targetFile.exists()) {
            throw new Exception("Invalid target file:" + targetFile.getAbsolutePath());
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int i = -1;
        byte[] bt = new byte[1024 * 2];
        while ((i = bis.read(bt)) != -1) {
            bos.write(bt, 0, i);
        }
        bis.close();
        bos.close();
    }

    public Boolean deleteFilesOrFolders(String path, Boolean deleteFolder) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File f : files) {
                if (f.isDirectory() && deleteFolder) {
                    deleteFilesOrFolders(f.getAbsolutePath(), deleteFolder);
                    continue;
                }
                if (f.isDirectory() && !deleteFolder) {
                    continue;
                }
                if (!f.isDirectory()) {
                    f.delete();
                }
            }
            return true;
        }
        return file.delete();
    }

    public Boolean deleteFilesAndFolders(String path) {
        return deleteFilesOrFolders(path, true);
    }

    public Boolean deleteAllFiles(String path) {
        return deleteFilesOrFolders(path, false);
    }

    public void createFile(String data, String filePath) {
        try {
            FileOutputStream output = new FileOutputStream(filePath);
            output.write(data.getBytes());
            output.close();
            logger.info("Create file to: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}