package com.example.quran.search;

public class ArabicNormalizer {
    public static String removeTashkeel(String text) {
        if (text == null) return null;
        return text
                .replaceAll("[\\u064B-\\u0652]", "")    // التشكيل الأساسي
                .replaceAll("[\\u0610-\\u061A]", "")    // رموز قرآنية
                .replaceAll("[\\u06D6-\\u06ED]", "")    // علامات التلاوة
                .replaceAll("ٱ", "ا")                   // الألف الصغيرة
                .replaceAll("أ", "ا")
                .replaceAll("إ", "ا")
                .replaceAll("آ", "ا");
    }
}
