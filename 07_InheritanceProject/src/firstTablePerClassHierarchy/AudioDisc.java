/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package firstTablePerClassHierarchy;

public class AudioDisc extends Disc{
    private String singer;
    private Integer numOfSongs;

    public Integer getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(Integer numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    
}
