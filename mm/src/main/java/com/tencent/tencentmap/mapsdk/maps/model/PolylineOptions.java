package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PolylineOptions {
    private static final int COLOR_DEFAULT_POLYLINE = Color.argb(200, 0, (int) TbsListener.ErrorCode.STARTDOWNLOAD_4, 255);
    private static final int LINE_DEFAULT_WIDTH = 9;
    private static final int LINE_UNINITIALIZED_WIDTH = -1;
    @Deprecated
    private static String sDefaultArrowTexture;
    private static String sDefaultColorTexture = "color_texture_flat_style.png";
    private float alpha = 1.0f;
    private boolean boArraw;
    private boolean boIsAbove = false;
    private boolean boIsGeodes = false;
    private boolean boVisible = true;
    private ColorType colorType = ColorType.LINE_COLOR_NONE;
    private int eraseColor = -7829368;
    private float fBorderWidth;
    private int fIndex = 0;
    private float fwidth = -1.0f;
    private int[] iBorderColors = {-16711936};
    private int[] iColors = null;
    private int[] iIndexs = null;
    private int iLevel = OverlayLevel.OverlayLevelAboveRoads;
    private int iStrokeColor = COLOR_DEFAULT_POLYLINE;
    private Animation initAnimation;
    private boolean lineCap = true;
    private int lineType = 0;
    private final List<LatLng> listLatLngs = new ArrayList();
    private boolean mAboveMaskLayer = false;
    private int mArrowSpacing = 150;
    private BitmapDescriptor mArrowTexture = null;
    private boolean mClickable = true;
    private BitmapDescriptor mCustomeColorTexture = BitmapDescriptorFactory.fromAsset(sDefaultColorTexture);
    private IndoorInfo mIndoorInfo;
    private boolean mIsRoad = true;
    private Text mText;
    private List<Integer> pattern;
    @Deprecated
    private String strCustomerTextName = sDefaultColorTexture;

    public static final class Colors {
        public static final int DARK_BLUE = 6;
        public static final int DASHED = 33;
        public static final int GRAYBLUE = 8;
        public static final int GREEN = 4;
        public static final int GREY = 0;
        public static final int LAST_BLUE = 20;
        public static final int LIGHT_BLUE = 1;
        public static final int LIVER_RED = 9;
        public static final int MID_BLUE = 5;
        public static final int RED = 2;
        public static final int TRANSPARENT = 7;
        public static final int WHITE_BLUE = 19;
        public static final int YELLOW = 3;
    }

    public static final class LineType {
        public static final int LINE_TYPE_DOTTEDLINE = 2;
        public static final int LINE_TYPE_IMAGEINARYLINE = 1;
        public static final int LINE_TYPE_MULTICOLORLINE = 0;
    }

    static {
        AppMethodBeat.i(181087);
        AppMethodBeat.o(181087);
    }

    public PolylineOptions() {
        AppMethodBeat.i(173357);
        AppMethodBeat.o(173357);
    }

    @Deprecated
    public void setLatLngs(List<LatLng> list) {
        AppMethodBeat.i(173358);
        latLngs(list);
        AppMethodBeat.o(173358);
    }

    public PolylineOptions latLngs(List<LatLng> list) {
        AppMethodBeat.i(173359);
        if (list != null) {
            this.listLatLngs.clear();
            this.listLatLngs.addAll(list);
        }
        AppMethodBeat.o(173359);
        return this;
    }

    public PolylineOptions add(LatLng latLng, LatLng... latLngArr) {
        AppMethodBeat.i(173360);
        this.listLatLngs.add(latLng);
        if (latLngArr != null) {
            add(latLngArr);
        }
        AppMethodBeat.o(173360);
        return this;
    }

    public PolylineOptions add(LatLng[] latLngArr) {
        AppMethodBeat.i(173361);
        if (latLngArr != null) {
            this.listLatLngs.addAll(Arrays.asList(latLngArr));
        }
        AppMethodBeat.o(173361);
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        AppMethodBeat.i(173362);
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                add(latLng, new LatLng[0]);
            }
        }
        AppMethodBeat.o(173362);
        return this;
    }

    public PolylineOptions updatePoints(Iterable<LatLng> iterable) {
        AppMethodBeat.i(181086);
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                arrayList.add(latLng);
            }
        }
        this.listLatLngs.clear();
        addAll(arrayList);
        AppMethodBeat.o(181086);
        return this;
    }

    public PolylineOptions width(float f2) {
        if (f2 < 0.0f) {
            this.fwidth = 9.0f;
        } else {
            if (f2 > 128.0f) {
                f2 = 128.0f;
            }
            this.fwidth = f2;
        }
        return this;
    }

    public PolylineOptions borderWidth(float f2) {
        if (f2 < 0.0f) {
            this.fBorderWidth = 1.0f;
        } else {
            this.fBorderWidth = f2;
        }
        return this;
    }

    public PolylineOptions colorType(ColorType colorType2) {
        this.colorType = colorType2;
        return this;
    }

    public ColorType getColorType() {
        return this.colorType;
    }

    public PolylineOptions color(int i2) {
        this.iStrokeColor = i2;
        return this;
    }

    public PolylineOptions colors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
        return this;
    }

    public PolylineOptions borderColors(int[] iArr) {
        this.iBorderColors = iArr;
        return this;
    }

    public PolylineOptions borderColor(int i2) {
        this.iBorderColors = new int[]{i2};
        return this;
    }

    public PolylineOptions eraseColor(int i2) {
        this.eraseColor = i2;
        return this;
    }

    public int getEraseColor() {
        return this.eraseColor;
    }

    public PolylineOptions zIndex(int i2) {
        AppMethodBeat.i(173363);
        this.fIndex = Math.max(0, i2);
        AppMethodBeat.o(173363);
        return this;
    }

    public PolylineOptions indoorInfo(IndoorInfo indoorInfo) {
        if (indoorInfo != null) {
            this.mIndoorInfo = indoorInfo;
            this.boIsAbove = true;
        }
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    @Deprecated
    public void setColors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
    }

    private PolylineOptions geodesic(boolean z) {
        this.boIsGeodes = z;
        return this;
    }

    public PolylineOptions arrow(boolean z) {
        this.boArraw = z;
        return this;
    }

    public PolylineOptions abovePillar(boolean z) {
        this.boIsAbove = z;
        if (this.mIndoorInfo != null) {
            this.boIsAbove = true;
        }
        return this;
    }

    public PolylineOptions alpha(float f2) {
        this.alpha = f2;
        return this;
    }

    public PolylineOptions lineCap(boolean z) {
        this.lineCap = z;
        return this;
    }

    public PolylineOptions animation(Animation animation) {
        this.initAnimation = animation;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.listLatLngs;
    }

    public float getWidth() {
        return this.fwidth;
    }

    public int getColor() {
        return this.iStrokeColor;
    }

    public int[][] getColors() {
        if (this.iColors == null || this.iIndexs == null || this.iColors.length != this.iIndexs.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, 2, this.iColors.length);
        iArr[0] = this.iColors;
        iArr[1] = this.iIndexs;
        return iArr;
    }

    public int getZIndex() {
        return this.fIndex;
    }

    public IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    private boolean isGeodesic() {
        return this.boIsGeodes;
    }

    public boolean isArrow() {
        return this.boArraw;
    }

    public boolean isAbovePillar() {
        return this.boIsAbove;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public boolean getLineCap() {
        return this.lineCap;
    }

    public Animation getAnimation() {
        return this.initAnimation;
    }

    public int getLineType() {
        return this.lineType;
    }

    @Deprecated
    public PolylineOptions setLineType(int i2) {
        AppMethodBeat.i(173364);
        PolylineOptions lineType2 = lineType(i2);
        AppMethodBeat.o(173364);
        return lineType2;
    }

    public PolylineOptions lineType(int i2) {
        this.lineType = i2;
        return this;
    }

    @Deprecated
    public PolylineOptions setColorTexture(String str) {
        AppMethodBeat.i(173365);
        this.strCustomerTextName = str;
        PolylineOptions colorTexture = colorTexture(BitmapDescriptorFactory.fromAsset(str));
        AppMethodBeat.o(173365);
        return colorTexture;
    }

    public PolylineOptions colorTexture(BitmapDescriptor bitmapDescriptor) {
        this.mCustomeColorTexture = bitmapDescriptor;
        this.colorType = ColorType.LINE_COLOR_TEXTURE;
        return this;
    }

    @Deprecated
    public String getTextureName() {
        return this.strCustomerTextName;
    }

    public BitmapDescriptor getColorTexture() {
        return this.mCustomeColorTexture;
    }

    public PolylineOptions aboveMaskLayer(boolean z) {
        this.mAboveMaskLayer = z;
        return this;
    }

    public boolean isAboveMaskLayer() {
        return this.mAboveMaskLayer;
    }

    public PolylineOptions road(boolean z) {
        this.mIsRoad = z;
        return this;
    }

    public boolean isRoad() {
        return this.mIsRoad;
    }

    public PolylineOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        this.mArrowTexture = bitmapDescriptor;
        return this;
    }

    public PolylineOptions arrowSpacing(int i2) {
        this.mArrowSpacing = i2;
        return this;
    }

    @Deprecated
    public static void setDefaultArrowTexture(String str) {
        sDefaultArrowTexture = str;
    }

    @Deprecated
    public static String getsDefaultArrowTexture() {
        return sDefaultArrowTexture;
    }

    public BitmapDescriptor getArrowTexture() {
        return this.mArrowTexture;
    }

    public int getArrowSpacing() {
        return this.mArrowSpacing;
    }

    public PolylineOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(173366);
        if (parcel == null) {
            AppMethodBeat.o(173366);
            return;
        }
        parcel.writeFloat(this.fwidth);
        AppMethodBeat.o(173366);
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public PolylineOptions pattern(List<Integer> list) {
        this.pattern = list;
        return this;
    }

    public float getBorderWidth() {
        return this.fBorderWidth;
    }

    public int[] getBorderColors() {
        return this.iBorderColors;
    }

    public PolylineOptions text(Text text) {
        this.mText = text;
        return this;
    }

    public Text getText() {
        return this.mText;
    }

    public static final class Text {
        private Builder mBuilder;
        private final List<SegmentText> mSegmentTexts;

        public static final class Builder {
            private List<SegmentText> mTexts = new ArrayList();
            private TextPriority priority = TextPriority.HIGH;
            private int strokeColor = -1;
            private int textColor = WebView.NIGHT_MODE_COLOR;
            private int textSize = 14;

            public Builder(SegmentText segmentText) {
                AppMethodBeat.i(173340);
                addSegmentText(segmentText);
                AppMethodBeat.o(173340);
            }

            public Builder(List<SegmentText> list) {
                AppMethodBeat.i(173341);
                addAllSegmentText(list);
                AppMethodBeat.o(173341);
            }

            public final Builder addSegmentText(SegmentText segmentText) {
                AppMethodBeat.i(173342);
                this.mTexts.add(segmentText);
                AppMethodBeat.o(173342);
                return this;
            }

            public final Builder addAllSegmentText(List<SegmentText> list) {
                AppMethodBeat.i(173343);
                this.mTexts.addAll(list);
                AppMethodBeat.o(173343);
                return this;
            }

            public final Builder color(int i2) {
                this.textColor = i2;
                return this;
            }

            public final Builder strokeColor(int i2) {
                this.strokeColor = i2;
                return this;
            }

            public final Builder size(int i2) {
                this.textSize = i2;
                return this;
            }

            public final Builder priority(TextPriority textPriority) {
                this.priority = textPriority;
                return this;
            }

            public final Text build() {
                AppMethodBeat.i(173344);
                Text text = new Text(this);
                AppMethodBeat.o(173344);
                return text;
            }
        }

        private Text(Builder builder) {
            AppMethodBeat.i(173345);
            this.mSegmentTexts = Collections.unmodifiableList(builder.mTexts);
            this.mBuilder = builder;
            AppMethodBeat.o(173345);
        }

        public final List<SegmentText> getSegmentTexts() {
            return this.mSegmentTexts;
        }

        public final int getTextColor() {
            AppMethodBeat.i(173346);
            int i2 = this.mBuilder.textColor;
            AppMethodBeat.o(173346);
            return i2;
        }

        public final void setTextColor(int i2) {
            AppMethodBeat.i(173347);
            this.mBuilder.textColor = i2;
            AppMethodBeat.o(173347);
        }

        public final int getStrokeColor() {
            AppMethodBeat.i(173348);
            int i2 = this.mBuilder.strokeColor;
            AppMethodBeat.o(173348);
            return i2;
        }

        public final void setStrokeColor(int i2) {
            AppMethodBeat.i(173349);
            this.mBuilder.strokeColor = i2;
            AppMethodBeat.o(173349);
        }

        public final int getTextSize() {
            AppMethodBeat.i(173350);
            int i2 = this.mBuilder.textSize;
            AppMethodBeat.o(173350);
            return i2;
        }

        public final void setTextSize(int i2) {
            AppMethodBeat.i(173351);
            this.mBuilder.textSize = i2;
            AppMethodBeat.o(173351);
        }

        public final TextPriority getPriority() {
            AppMethodBeat.i(173352);
            TextPriority textPriority = this.mBuilder.priority;
            AppMethodBeat.o(173352);
            return textPriority;
        }

        public final void setPriority(TextPriority textPriority) {
            AppMethodBeat.i(173353);
            this.mBuilder.priority = textPriority;
            AppMethodBeat.o(173353);
        }
    }

    public static final class SegmentText {
        private final int endIndex;
        private final int startIndex;
        private final String text;

        public SegmentText(int i2, int i3, String str) {
            this.startIndex = i2;
            this.endIndex = i3;
            this.text = str;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final String getText() {
            return this.text;
        }
    }

    public enum TextPriority {
        NORMAL,
        HIGH;

        public static TextPriority valueOf(String str) {
            AppMethodBeat.i(173355);
            TextPriority textPriority = (TextPriority) Enum.valueOf(TextPriority.class, str);
            AppMethodBeat.o(173355);
            return textPriority;
        }

        static {
            AppMethodBeat.i(173356);
            AppMethodBeat.o(173356);
        }
    }

    public enum ColorType {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB;

        public static ColorType valueOf(String str) {
            AppMethodBeat.i(173338);
            ColorType colorType = (ColorType) Enum.valueOf(ColorType.class, str);
            AppMethodBeat.o(173338);
            return colorType;
        }

        static {
            AppMethodBeat.i(173339);
            AppMethodBeat.o(173339);
        }
    }
}
