package com.tencent.midas.api.request;

public class APMidasGameRequest extends APMidasBaseRequest {
    private static final long serialVersionUID = -1453333674013082952L;
    public int gameLogo = 0;

    public int getGameLogo() {
        return this.gameLogo;
    }

    public void setGameLogo(int i2) {
        this.gameLogo = i2;
    }
}
