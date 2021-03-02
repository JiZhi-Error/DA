package com.tencent.mm.plugin.luckymoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class LuckyMoneyEmojiSwitch implements Parcelable {
    public static final Parcelable.Creator<LuckyMoneyEmojiSwitch> CREATOR = new Parcelable.Creator<LuckyMoneyEmojiSwitch>() {
        /* class com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LuckyMoneyEmojiSwitch[] newArray(int i2) {
            return new LuckyMoneyEmojiSwitch[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LuckyMoneyEmojiSwitch createFromParcel(Parcel parcel) {
            AppMethodBeat.i(65184);
            LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch(parcel);
            AppMethodBeat.o(65184);
            return luckyMoneyEmojiSwitch;
        }
    };
    public int yVG = 0;
    public int yVH = 0;
    public int yVI = 0;
    public int yVJ = 0;

    public static LuckyMoneyEmojiSwitch aX(JSONObject jSONObject) {
        AppMethodBeat.i(65185);
        LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
        luckyMoneyEmojiSwitch.yVG = jSONObject.optInt("showOpenNormalExpression", 0);
        luckyMoneyEmojiSwitch.yVH = jSONObject.optInt("showDetailNormalExpression", 0);
        luckyMoneyEmojiSwitch.yVI = jSONObject.optInt("enableAnswerByExpression", 0);
        luckyMoneyEmojiSwitch.yVJ = jSONObject.optInt("enableAnswerBySelfie", 0);
        AppMethodBeat.o(65185);
        return luckyMoneyEmojiSwitch;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(65186);
        parcel.writeInt(this.yVG);
        parcel.writeInt(this.yVH);
        parcel.writeInt(this.yVI);
        parcel.writeInt(this.yVJ);
        AppMethodBeat.o(65186);
    }

    public LuckyMoneyEmojiSwitch() {
    }

    protected LuckyMoneyEmojiSwitch(Parcel parcel) {
        AppMethodBeat.i(65187);
        this.yVG = parcel.readInt();
        this.yVH = parcel.readInt();
        this.yVI = parcel.readInt();
        this.yVJ = parcel.readInt();
        AppMethodBeat.o(65187);
    }

    static {
        AppMethodBeat.i(65189);
        AppMethodBeat.o(65189);
    }

    public String toString() {
        AppMethodBeat.i(65188);
        String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.yVG + ", showDetailNormalExpression=" + this.yVH + ", enalbeAnswerByExpression=" + this.yVI + ", enableAnswerBySelfie=" + this.yVJ + '}';
        AppMethodBeat.o(65188);
        return str;
    }
}
