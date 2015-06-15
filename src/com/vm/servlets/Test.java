package com.vm.servlets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpeg");

        String widthS;
        String heightS;
        String colorS;
        int width;
        int height;
        int color;

        try {
            widthS = request.getParameter("width");
            heightS = request.getParameter("height");
            colorS = request.getParameter("color");
            width = Integer.parseInt(widthS);
            height = Integer.parseInt(heightS);
            color = Integer.parseInt(colorS);
            System.out.println("width" + request.getParameter("width"));
            System.out.println("height" + request.getParameter("height"));
            System.out.println("color" + request.getParameter("color"));
        }
        catch (Exception e) {
            width = 300;
            height = 150;
            color = 0;
            System.out.println(e);
            System.out.println("width" + request.getParameter("width"));
            System.out.println("height" + request.getParameter("height"));
            System.out.println("color" + request.getParameter("color"));
        }

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        switch(color){

            case 1:
                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.YELLOW.getRGB());
                    }
                }
                break;

            case 2:
                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.GREEN.getRGB());
                    }
                }
                break;

            case 3:
                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.BLUE.getRGB());
                    }
                }
                break;

            case 4:

                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.RED.getRGB());
                    }
                }
                break;

            case 5:
                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.WHITE.getRGB());
                    }
                }
                break;

            default:
                for(int x = 0; x < img.getWidth(); x++){
                    for(int y = 0; y < img.getHeight(); y++){
                        img.setRGB(x,y,Color.BLACK.getRGB());
                    }
                }
                break;
        }

        OutputStream out = response.getOutputStream();
        ImageIO.write(img, "jpg", out);
        out.flush();

    }

}