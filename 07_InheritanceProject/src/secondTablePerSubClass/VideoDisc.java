/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secondTablePerSubClass;

/**
 *
 * @author SrikanthMD
 */
public class VideoDisc extends Disc{
    private String director;
    private String language;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
