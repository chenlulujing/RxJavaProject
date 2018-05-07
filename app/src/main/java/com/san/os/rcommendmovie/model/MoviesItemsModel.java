package com.san.os.rcommendmovie.model;

import java.util.List;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-11-13 23:06
 */

public class MoviesItemsModel {
    public List<SearchCar> suglist;
    public Brand brand;

    public static class Brand {
        public String name;
        public int id;
        public String spell;
        public int onsale;
        public String stopsale;
        public int tobasale;
    }
}
