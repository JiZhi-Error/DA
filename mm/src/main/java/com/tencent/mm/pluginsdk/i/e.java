package com.tencent.mm.pluginsdk.i;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class e {
    public static CharSequence a(CharSequence charSequence, Time time) {
        String format;
        int i2;
        int i3;
        AppMethodBeat.i(151896);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = 1;
            char charAt = spannableStringBuilder.charAt(i4);
            if (charAt == '\'') {
                i2 = a(spannableStringBuilder, i4, length);
                i3 = spannableStringBuilder.length();
            } else {
                while (i4 + i5 < length && spannableStringBuilder.charAt(i4 + i5) == charAt) {
                    i5++;
                }
                switch (charAt) {
                    case 'A':
                        format = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'E':
                        format = DateUtils.getDayOfWeekString(time.weekDay + 1, i5 < 4 ? 20 : 10);
                        break;
                    case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                    case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                        int i6 = time.month;
                        if (i5 < 4) {
                            if (i5 != 3) {
                                format = kB(i6 + 1, i5);
                                break;
                            } else {
                                format = DateUtils.getMonthString(i6, 20);
                                break;
                            }
                        } else {
                            format = DateUtils.getMonthString(i6, 10);
                            break;
                        }
                    case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                        format = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'd':
                        format = kB(time.monthDay, i5);
                        break;
                    case 'h':
                        int i7 = time.hour;
                        if (i7 == 0) {
                            i7 = 12;
                        }
                        if (i7 > 12) {
                            i7 -= 12;
                        }
                        format = String.valueOf(i7);
                        break;
                    case 'k':
                        format = kB(time.hour, i5);
                        break;
                    case 'm':
                        format = kB(time.minute, i5);
                        break;
                    case 's':
                        format = kB(time.second, i5);
                        break;
                    case 'y':
                        int i8 = time.year;
                        if (i5 > 2) {
                            format = String.format(Locale.getDefault(), "%d", Integer.valueOf(i8));
                            break;
                        } else {
                            format = kB(i8 % 100, 2);
                            break;
                        }
                    case 'z':
                        TimeZone timeZone = TimeZone.getDefault();
                        timeZone.inDaylightTime(new Date(time.toMillis(false)));
                        if (i5 >= 2) {
                            format = timeZone.getDisplayName(time.isDst != 0, 0);
                            break;
                        } else {
                            long rawOffset = (((long) timeZone.getRawOffset()) + time.gmtoff) / 1000;
                            StringBuilder sb = new StringBuilder();
                            if (rawOffset < 0) {
                                sb.insert(0, "-");
                                rawOffset = -rawOffset;
                            } else {
                                sb.insert(0, "+");
                            }
                            sb.append(kB((int) (rawOffset / 3600), 2));
                            sb.append(kB((int) ((rawOffset % 3600) / 60), 2));
                            format = sb.toString();
                            break;
                        }
                    default:
                        format = null;
                        break;
                }
                if (format != null) {
                    spannableStringBuilder.replace(i4, i4 + i5, (CharSequence) format);
                    i2 = format.length();
                    i3 = spannableStringBuilder.length();
                } else {
                    i2 = i5;
                    i3 = length;
                }
            }
            i4 = i2 + i4;
            length = i3;
        }
        if (charSequence instanceof Spanned) {
            SpannedString spannedString = new SpannedString(spannableStringBuilder);
            AppMethodBeat.o(151896);
            return spannedString;
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        AppMethodBeat.o(151896);
        return spannableStringBuilder2;
    }

    private static int a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        AppMethodBeat.i(151897);
        if (i2 + 1 >= i3 || spannableStringBuilder.charAt(i2 + 1) != '\'') {
            int i4 = 0;
            spannableStringBuilder.delete(i2, i2 + 1);
            int i5 = i3 - 1;
            while (true) {
                if (i2 >= i5) {
                    break;
                } else if (spannableStringBuilder.charAt(i2) != '\'') {
                    i2++;
                    i4++;
                } else if (i2 + 1 >= i5 || spannableStringBuilder.charAt(i2 + 1) != '\'') {
                    spannableStringBuilder.delete(i2, i2 + 1);
                } else {
                    spannableStringBuilder.delete(i2, i2 + 1);
                    i5--;
                    i4++;
                    i2++;
                }
            }
            spannableStringBuilder.delete(i2, i2 + 1);
            AppMethodBeat.o(151897);
            return i4;
        }
        spannableStringBuilder.delete(i2, i2 + 1);
        AppMethodBeat.o(151897);
        return 1;
    }

    private static String kB(int i2, int i3) {
        AppMethodBeat.i(151898);
        if (i3 != 2) {
            String format = String.format(Locale.getDefault(), "%0" + i3 + "d", Integer.valueOf(i2));
            AppMethodBeat.o(151898);
            return format;
        } else if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(151898);
            return concat;
        } else {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(151898);
            return valueOf;
        }
    }
}
