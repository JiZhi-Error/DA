package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bki;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo implements Parcelable {
    public static final Parcelable.Creator<CardGiftInfo> CREATOR = new Parcelable.Creator<CardGiftInfo>() {
        /* class com.tencent.mm.plugin.card.model.CardGiftInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CardGiftInfo[] newArray(int i2) {
            return new CardGiftInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CardGiftInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(112717);
            CardGiftInfo cardGiftInfo = new CardGiftInfo(parcel);
            AppMethodBeat.o(112717);
            return cardGiftInfo;
        }
    };
    public String cardTpId;
    public String dJw;
    public String dYs;
    public String footerWording;
    public String ixw;
    public int pSA;
    public int pSB;
    public int pSC;
    public String pSD;
    public String pSE;
    public int pSF;
    public String pSG;
    public String pSH;
    public String pSI;
    public String pSJ;
    public String pSK;
    public String pSL;
    public String pSM;
    public String pSN;
    public LinkedList<AcceptedCardItem> pSO = new LinkedList<>();
    public LinkedList<AccepterItem> pSP = new LinkedList<>();
    public String pSQ;
    public int pSR;
    public String pSS;
    public String pST;
    public String pSU;
    public String pSV;
    public String pSW;
    public String pSX;
    public int pSY;
    public String pSZ;
    public String pSn;
    public String pSo;
    public String pSp;
    public String pSq;
    public String pSr;
    public String pSs;
    public String pSt;
    public String pSu;
    public String pSv;
    public String pSw;
    public String pSx;
    public String pSy;
    public boolean pSz;
    public String pTa;
    public String pTb;
    public String pTc;

    public CardGiftInfo() {
        AppMethodBeat.i(112726);
        AppMethodBeat.o(112726);
    }

    protected CardGiftInfo(Parcel parcel) {
        AppMethodBeat.i(112727);
        this.dJw = parcel.readString();
        this.dYs = parcel.readString();
        this.pSn = parcel.readString();
        this.pSo = parcel.readString();
        this.pSp = parcel.readString();
        this.pSq = parcel.readString();
        this.pSr = parcel.readString();
        this.pSs = parcel.readString();
        this.pSt = parcel.readString();
        this.pSu = parcel.readString();
        this.pSv = parcel.readString();
        this.pSw = parcel.readString();
        this.pSx = parcel.readString();
        this.pSy = parcel.readString();
        this.footerWording = parcel.readString();
        this.ixw = parcel.readString();
        this.pSz = parcel.readByte() != 0;
        this.pSA = parcel.readInt();
        this.pSB = parcel.readInt();
        this.pSC = parcel.readInt();
        this.pSD = parcel.readString();
        this.pSE = parcel.readString();
        this.pSF = parcel.readInt();
        this.pSG = parcel.readString();
        this.pSH = parcel.readString();
        this.pSI = parcel.readString();
        this.pSJ = parcel.readString();
        this.pSK = parcel.readString();
        this.pSL = parcel.readString();
        this.pSM = parcel.readString();
        this.cardTpId = parcel.readString();
        this.pSN = parcel.readString();
        parcel.readTypedList(this.pSO, AcceptedCardItem.CREATOR);
        parcel.readTypedList(this.pSP, AccepterItem.CREATOR);
        this.pSQ = parcel.readString();
        this.pSR = parcel.readInt();
        this.pSS = parcel.readString();
        this.pST = parcel.readString();
        this.pST = parcel.readString();
        this.pSU = parcel.readString();
        this.pSV = parcel.readString();
        this.pSW = parcel.readString();
        this.pSX = parcel.readString();
        this.pSY = parcel.readInt();
        this.pSZ = parcel.readString();
        this.pTa = parcel.readString();
        this.pTb = parcel.readString();
        this.pTc = parcel.readString();
        AppMethodBeat.o(112727);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(112728);
        parcel.writeString(this.dJw);
        parcel.writeString(this.dYs);
        parcel.writeString(this.pSn);
        parcel.writeString(this.pSo);
        parcel.writeString(this.pSp);
        parcel.writeString(this.pSq);
        parcel.writeString(this.pSr);
        parcel.writeString(this.pSs);
        parcel.writeString(this.pSt);
        parcel.writeString(this.pSu);
        parcel.writeString(this.pSv);
        parcel.writeString(this.pSw);
        parcel.writeString(this.pSx);
        parcel.writeString(this.pSy);
        parcel.writeString(this.footerWording);
        parcel.writeString(this.ixw);
        parcel.writeByte(this.pSz ? (byte) 1 : 0);
        parcel.writeInt(this.pSA);
        parcel.writeInt(this.pSB);
        parcel.writeInt(this.pSC);
        parcel.writeString(this.pSD);
        parcel.writeString(this.pSE);
        parcel.writeInt(this.pSF);
        parcel.writeString(this.pSG);
        parcel.writeString(this.pSH);
        parcel.writeString(this.pSI);
        parcel.writeString(this.pSJ);
        parcel.writeString(this.pSK);
        parcel.writeString(this.pSL);
        parcel.writeString(this.pSM);
        parcel.writeString(this.cardTpId);
        parcel.writeString(this.pSN);
        parcel.writeTypedList(this.pSO);
        parcel.writeTypedList(this.pSP);
        parcel.writeString(this.pSQ);
        parcel.writeInt(this.pSR);
        parcel.writeString(this.pSS);
        parcel.writeString(this.pST);
        parcel.writeString(this.pST);
        parcel.writeString(this.pSU);
        parcel.writeString(this.pSV);
        parcel.writeString(this.pSW);
        parcel.writeString(this.pSX);
        parcel.writeInt(this.pSY);
        parcel.writeString(this.pSZ);
        parcel.writeString(this.pTa);
        parcel.writeString(this.pTb);
        parcel.writeString(this.pTc);
        AppMethodBeat.o(112728);
    }

    static {
        AppMethodBeat.i(112732);
        AppMethodBeat.o(112732);
    }

    public String toString() {
        AppMethodBeat.i(112729);
        String str = "CardGiftInfo{toUserName='" + this.dJw + '\'' + ", fromUserName='" + this.dYs + '\'' + ", fromUserImgUrl='" + this.pSn + '\'' + ", fromUserContent='" + this.pSo + '\'' + ", fromUserContentPicUrl='" + this.pSp + '\'' + ", fromUserContentVideoUrl='" + this.pSq + '\'' + ", fromUserContentThumbPicUrl='" + this.pSr + '\'' + ", picAESKey='" + this.pSs + '\'' + ", videoAESKey='" + this.pSt + '\'' + ", thumbVideoAESKey='" + this.pSu + '\'' + ", cardBackgroundPicUrl='" + this.pSv + '\'' + ", cardLogoLUrl='" + this.pSw + '\'' + ", cardTitle='" + this.pSx + '\'' + ", cardPrice='" + this.pSy + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.ixw + '\'' + ", needJump=" + this.pSz + ", picDataLength=" + this.pSA + ", videoDataLength=" + this.pSB + ", thumbDataLength=" + this.pSC + ", descTitle='" + this.pSD + '\'' + ", descIconUrl='" + this.pSE + '\'' + ", descLayoutMode=" + this.pSF + ", giftingMediaTitle='" + this.pSG + '\'' + ", descriptionTitleColor='" + this.pSH + '\'' + ", cardTitleColor='" + this.pSI + '\'' + ", cardPriceTitleColor='" + this.pSJ + '\'' + ", userCardId='" + this.pSK + '\'' + ", operationTitle='" + this.pSL + '\'' + ", operationUrl='" + this.pSM + '\'' + ", cardTpId='" + this.cardTpId + '\'' + ", cardCode='" + this.pSN + '\'' + ", accepted_card_list_size='" + this.pSO.size() + '\'' + ", accepter_list_size='" + this.pSP.size() + '\'' + ", accepter_list_title='" + this.pSQ + '\'' + ", out_of_card='" + this.pSR + '\'' + ", operation_wxa_username='" + this.pSS + '\'' + ", operation_wxa_path='" + this.pST + '\'' + '}';
        AppMethodBeat.o(112729);
        return str;
    }

    public static CardGiftInfo a(as asVar) {
        AppMethodBeat.i(112730);
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.dJw = asVar.KDp;
        cardGiftInfo.dYs = asVar.KDq;
        cardGiftInfo.pSn = asVar.KDr;
        cardGiftInfo.pSo = asVar.content;
        cardGiftInfo.pSp = asVar.KDs;
        cardGiftInfo.pSq = asVar.KDt;
        cardGiftInfo.pSr = asVar.KDu;
        cardGiftInfo.pSs = asVar.KDv;
        cardGiftInfo.pSu = asVar.KDx;
        cardGiftInfo.pSt = asVar.KDw;
        cardGiftInfo.pSv = asVar.KDy;
        cardGiftInfo.pSw = asVar.KDz;
        cardGiftInfo.pSx = asVar.pTd;
        cardGiftInfo.pSy = asVar.pTe;
        cardGiftInfo.footerWording = asVar.KDA;
        cardGiftInfo.ixw = asVar.ixw;
        cardGiftInfo.pSz = asVar.KDB;
        cardGiftInfo.pSA = asVar.KDC;
        cardGiftInfo.pSB = asVar.KDD;
        cardGiftInfo.pSC = asVar.KDE;
        cardGiftInfo.pSD = asVar.KDF;
        cardGiftInfo.pSE = asVar.KDG;
        cardGiftInfo.pSF = asVar.KDH;
        cardGiftInfo.pSG = asVar.KDI;
        cardGiftInfo.pSH = asVar.KDJ;
        cardGiftInfo.pSI = asVar.KDK;
        cardGiftInfo.pSJ = asVar.KDL;
        cardGiftInfo.pSK = asVar.KDM;
        cardGiftInfo.pSL = asVar.KDN;
        cardGiftInfo.pSM = asVar.KDO;
        cardGiftInfo.cardTpId = asVar.pRX;
        cardGiftInfo.pSN = asVar.KDP;
        Iterator<av> it = asVar.pSO.iterator();
        while (it.hasNext()) {
            av next = it.next();
            LinkedList<AcceptedCardItem> linkedList = cardGiftInfo.pSO;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.pTe = next.pTe;
            acceptedCardItem.pTd = next.pTd;
            linkedList.add(acceptedCardItem);
        }
        Iterator<aw> it2 = asVar.pSP.iterator();
        while (it2.hasNext()) {
            aw next2 = it2.next();
            LinkedList<AccepterItem> linkedList2 = cardGiftInfo.pSP;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.pTe = next2.pTe;
            accepterItem.pTd = next2.pTd;
            accepterItem.pTg = next2.pTg;
            accepterItem.pTf = next2.pTf;
            linkedList2.add(accepterItem);
        }
        cardGiftInfo.pSQ = asVar.pSQ;
        cardGiftInfo.pSR = asVar.pSR;
        cardGiftInfo.pSS = asVar.pSS;
        cardGiftInfo.pST = asVar.pST;
        cardGiftInfo.pSU = asVar.pSU;
        cardGiftInfo.pSV = asVar.pSV;
        cardGiftInfo.pSW = asVar.pSW;
        cardGiftInfo.pSX = asVar.pSX;
        cardGiftInfo.pSY = asVar.pSY;
        cardGiftInfo.pSZ = asVar.pSZ;
        cardGiftInfo.pTb = asVar.pTb;
        cardGiftInfo.pTa = asVar.pTa;
        cardGiftInfo.pTc = asVar.pTc;
        AppMethodBeat.o(112730);
        return cardGiftInfo;
    }

    public static CardGiftInfo a(bki bki) {
        AppMethodBeat.i(112731);
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.dJw = bki.KDp;
        cardGiftInfo.dYs = bki.KDq;
        cardGiftInfo.pSn = bki.KDr;
        cardGiftInfo.pSo = bki.content;
        cardGiftInfo.pSp = bki.KDs;
        cardGiftInfo.pSq = bki.KDt;
        cardGiftInfo.pSr = bki.KDu;
        cardGiftInfo.pSs = bki.KDv;
        cardGiftInfo.pSu = bki.KDx;
        cardGiftInfo.pSt = bki.KDw;
        cardGiftInfo.pSv = bki.KDy;
        cardGiftInfo.pSw = bki.KDz;
        cardGiftInfo.pSx = bki.pTd;
        cardGiftInfo.pSy = bki.pTe;
        cardGiftInfo.footerWording = bki.KDA;
        cardGiftInfo.ixw = bki.ixw;
        cardGiftInfo.pSz = bki.KDB;
        cardGiftInfo.pSA = bki.KDC;
        cardGiftInfo.pSB = bki.KDD;
        cardGiftInfo.pSC = bki.KDE;
        cardGiftInfo.pSD = bki.KDF;
        cardGiftInfo.pSE = bki.KDG;
        cardGiftInfo.pSF = bki.LTy;
        cardGiftInfo.pSG = bki.KDI;
        cardGiftInfo.pSH = bki.KDJ;
        cardGiftInfo.pSI = bki.KDK;
        cardGiftInfo.pSJ = bki.KDL;
        cardGiftInfo.pSK = bki.KDM;
        cardGiftInfo.pSL = bki.KDN;
        cardGiftInfo.pSM = bki.KDO;
        cardGiftInfo.cardTpId = bki.pRX;
        cardGiftInfo.pSN = bki.KDP;
        cardGiftInfo.pSS = bki.pSS;
        cardGiftInfo.pST = bki.pST;
        cardGiftInfo.pSU = bki.pSU;
        cardGiftInfo.pSV = bki.pSV;
        cardGiftInfo.pSW = bki.pSW;
        cardGiftInfo.pSX = bki.pSX;
        cardGiftInfo.pSY = bki.pSY;
        cardGiftInfo.pSZ = bki.pSZ;
        cardGiftInfo.pTb = bki.pTb;
        cardGiftInfo.pTa = bki.pTa;
        cardGiftInfo.pTc = bki.pTc;
        AppMethodBeat.o(112731);
        return cardGiftInfo;
    }

    public static class AcceptedCardItem implements Parcelable {
        public static final Parcelable.Creator<AcceptedCardItem> CREATOR = new Parcelable.Creator<AcceptedCardItem>() {
            /* class com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AcceptedCardItem[] newArray(int i2) {
                return new AcceptedCardItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AcceptedCardItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(112718);
                AcceptedCardItem acceptedCardItem = new AcceptedCardItem(parcel, (byte) 0);
                AppMethodBeat.o(112718);
                return acceptedCardItem;
            }
        };
        public String pTd;
        public String pTe;

        /* synthetic */ AcceptedCardItem(Parcel parcel, byte b2) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(112721);
            AppMethodBeat.o(112721);
        }

        public AcceptedCardItem() {
        }

        private AcceptedCardItem(Parcel parcel) {
            AppMethodBeat.i(112719);
            this.pTd = parcel.readString();
            this.pTe = parcel.readString();
            AppMethodBeat.o(112719);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(112720);
            parcel.writeString(this.pTd);
            parcel.writeString(this.pTe);
            AppMethodBeat.o(112720);
        }

        public int describeContents() {
            return 0;
        }
    }

    public static class AccepterItem implements Parcelable {
        public static final Parcelable.Creator<AccepterItem> CREATOR = new Parcelable.Creator<AccepterItem>() {
            /* class com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AccepterItem[] newArray(int i2) {
                return new AccepterItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AccepterItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(112722);
                AccepterItem accepterItem = new AccepterItem(parcel, (byte) 0);
                AppMethodBeat.o(112722);
                return accepterItem;
            }
        };
        public String pTd;
        public String pTe;
        public String pTf;
        public String pTg;

        /* synthetic */ AccepterItem(Parcel parcel, byte b2) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(112725);
            AppMethodBeat.o(112725);
        }

        public AccepterItem() {
        }

        private AccepterItem(Parcel parcel) {
            AppMethodBeat.i(112723);
            this.pTd = parcel.readString();
            this.pTe = parcel.readString();
            this.pTf = parcel.readString();
            this.pTg = parcel.readString();
            AppMethodBeat.o(112723);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(112724);
            parcel.writeString(this.pTd);
            parcel.writeString(this.pTe);
            parcel.writeString(this.pTf);
            parcel.writeString(this.pTg);
            AppMethodBeat.o(112724);
        }

        public int describeContents() {
            return 0;
        }
    }
}
