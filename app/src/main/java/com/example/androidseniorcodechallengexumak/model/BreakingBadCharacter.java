package com.example.androidseniorcodechallengexumak.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BreakingBadCharacter implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("char_id")
    private Integer charId;

    @SerializedName("occupation")
    private List<String> occupation;

    @SerializedName("status")
    private String status;

    @SerializedName("portrayed")
    private String portrayed;

    @SerializedName("img")
    private String img;

    public BreakingBadCharacter() {
    }

    public BreakingBadCharacter(String name,
                                String nickname,
                                Integer charId,
                                String status,
                                String portrayed,
                                String img) {
        this.name = name;
        this.nickname = nickname;
        this.charId = charId;
        this.status = status;
        this.portrayed = portrayed;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getOccupation() {
        String ocupations = "";
        for (int i = 0; i < occupation.size(); i++){
            if(i == 0){
                ocupations += occupation.get(i);
            }
            else{
                ocupations += (", " + occupation.get(i));
            }
        }
        return ocupations;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
