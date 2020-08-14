package com.github.dylanz666.util.asserts;

import com.github.dylanz666.domain.AllureAttachment;
import com.github.dylanz666.service.AllureAttachmentServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class Assert extends org.testng.Assert {
    @Autowired
    private static AllureAttachment allureAttachment;
    @Autowired
    private static AllureAttachmentServiceImpl allureAttachmentService;

    public static void assertTrue(boolean condition, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertTrue(" + condition + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertTrue(condition, message);
    }

    public static void assertTrue(boolean condition) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertTrue(" + condition + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        assertTrue(condition, null);
    }

    public static void assertFalse(boolean condition, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertFalse(" + condition + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertFalse(condition, message);
    }

    public static void assertFalse(boolean condition) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertFalse(" + condition + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        assertFalse(condition, null);
    }

    public static void fail(String message, Throwable realCause) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.fail(" + message + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.fail(message, realCause);
    }

    public static void fail(String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.fail(" + message + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.fail(message);
    }

    public static void fail() {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.fail()");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.fail();
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(byte[] actual, byte[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(byte[] actual, byte[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(short[] actual, short[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(short[] actual, short[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(int[] actual, int[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(int[] actual, int[] expected, String message) {
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(boolean[] actual, boolean[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(boolean[] actual, boolean[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(char[] actual, char[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(char[] actual, char[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(float[] actual, float[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(float[] actual, float[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(float[] actual, float[] expected, float delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta);
    }

    public static void assertEquals(float[] actual, float[] expected, float delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta, message);
    }

    public static void assertEquals(double[] actual, double[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(double[] actual, double[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(double[] actual, double[] expected, double delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta);
    }

    public static void assertEquals(double[] actual, double[] expected, double delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta, message);
    }

    public static void assertEquals(long[] actual, long[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(long[] actual, long[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(Object actual, Object expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(String actual, String expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(String actual, String expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(double actual, double expected, double delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta, message);
    }

    public static void assertEquals(double actual, double expected, double delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta);
    }

    public static void assertEquals(double actual, double expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(double actual, double expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(float actual, float expected, float delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta, message);
    }

    public static void assertEquals(float actual, float expected, float delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, delta);
    }

    public static void assertEquals(float actual, float expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(float actual, float expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(long actual, long expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(long actual, long expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(boolean actual, boolean expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(boolean actual, boolean expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(byte actual, byte expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(byte actual, byte expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(char actual, char expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(char actual, char expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(short actual, short expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(short actual, short expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(int actual, int expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(int actual, int expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertNotNull(Object object) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotNull(" + object + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotNull(object);
    }

    public static void assertNotNull(Object object, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotNull(" + object + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotNull(object, message);
    }

    public static void assertNull(Object object) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNull(" + object + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNull(object);
    }

    public static void assertNull(Object object, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNull(" + object + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNull(object, message);
    }

    public static void assertSame(Object actual, Object expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertSame(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertSame(actual, expected, message);
    }

    public static void assertSame(Object actual, Object expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertSame(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertSame(actual, expected);
    }

    public static void assertNotSame(Object actual, Object expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotSame(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotSame(actual, expected, message);
    }

    public static void assertNotSame(Object actual, Object expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotSame(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotSame(actual, expected);
    }

    public static void assertEquals(Collection<?> actual, Collection<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(Iterator<?> actual, Iterator<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Iterator<?> actual, Iterator<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(Iterable<?> actual, Iterable<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Iterable<?> actual, Iterable<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(Object[] actual, Object[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEqualsNoOrder(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEqualsNoOrder(actual, expected, message);
    }

    public static void assertEquals(Object[] actual, Object[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEqualsNoOrder(Object[] actual, Object[] expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEqualsNoOrder(" + Arrays.toString(actual) + "," + Arrays.toString(expected) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEqualsNoOrder(actual, expected);
    }

    public static void assertEquals(Set<?> actual, Set<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Set<?> actual, Set<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEqualsDeep(Set<?> actual, Set<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEqualsDeep(actual, expected, message);
    }

    public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    public static void assertEqualsDeep(Map<?, ?> actual, Map<?, ?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEqualsDeep(actual, expected);
    }

    public static void assertEqualsDeep(Map<?, ?> actual, Map<?, ?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEqualsDeep(actual, expected, message);
    }

    public static void assertNotEquals(Object actual1, Object actual2, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2, message);
    }

    public static void assertNotEquals(Object actual1, Object actual2) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2);
    }

    public static void assertNotEquals(float actual1, float actual2, float delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2, delta, message);
    }

    public static void assertNotEquals(float actual1, float actual2, float delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2, delta);
    }

    public static void assertNotEquals(double actual1, double actual2, double delta, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + "," + delta + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2, delta, message);
    }

    public static void assertNotEquals(Set<?> actual, Set<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual, expected);
    }

    public static void assertNotEquals(Set<?> actual, Set<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertNotEqualsDeep(Set<?> actual, Set<?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEqualsDeep(actual, expected);
    }

    public static void assertNotEqualsDeep(Set<?> actual, Set<?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEqualsDeep(actual, expected, message);
    }

    public static void assertNotEquals(Map<?, ?> actual, Map<?, ?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual, expected);
    }

    public static void assertNotEquals(Map<?, ?> actual, Map<?, ?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertNotEqualsDeep(Map<?, ?> actual, Map<?, ?> expected) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEqualsDeep(actual, expected);
    }

    public static void assertNotEqualsDeep(Map<?, ?> actual, Map<?, ?> expected, String message) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEqualsDeep(" + actual + "," + expected + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEqualsDeep(actual, expected, message);
    }

    public static void assertNotEquals(double actual1, double actual2, double delta) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.assertNotEquals(" + actual1 + "," + actual2 + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertNotEquals(actual1, actual2, delta);
    }

    public static void containsKey(JSONObject jsonObject, String key) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsKey(" + jsonObject + "," + key + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        assertThat(jsonObject).containsKey(key);
    }

    public static void containsKey(String jsonString, String key) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsKey(" + jsonString + "," + key + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        assertThat(jsonObject).containsKey(key);
    }

    public static void containsKeys(String jsonString, String... keys) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsKeys(" + jsonString + "," + String.join(",", keys) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        assertThat(jsonObject).containsKeys();
    }

    public static void containsKeys(JSONObject jsonObject, String... keys) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsKeys(" + jsonObject + "," + String.join(",", keys) + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        assertThat(jsonObject).containsKeys();
    }

    public static void hasAllKeys(JSONObject actual, JSONObject expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.hasAllKeys(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        for (Map.Entry<String, Object> entry : expect.entrySet()) {
            assertThat(actual).containsKeys(entry.getKey());
        }
    }

    public static void hasAllKeys(String actual, String expect) {
        JSONObject a = JSONObject.parseObject(actual);
        JSONObject e = JSONObject.parseObject(expect);
        hasAllKeys(a, e);
    }

    public static void hasSameKeys(JSONObject actual, JSONObject expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.hasSameKeys(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        for (Map.Entry<String, Object> entry : expect.entrySet()) {
            assertThat(actual).containsKeys(entry.getKey());
            org.testng.Assert.assertEquals(actual.size(), expect.size());
        }
    }

    public static void hasSameKeys(String actual, String expect) {
        JSONObject a = JSONObject.parseObject(actual);
        JSONObject e = JSONObject.parseObject(expect);
        hasSameKeys(a, e);
    }

    public static void hasSameItems(JSONArray actual, JSONArray expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.hasSameItems(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(actual.size(), expect.size());
        org.testng.Assert.assertTrue(expect.containsAll(actual));
    }

    public static void hasSameItems(String actual, String expect) {
        JSONArray a = JSONArray.parseArray(actual);
        JSONArray e = JSONArray.parseArray(expect);
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.hasSameItems(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertEquals(a.size(), e.size());
        org.testng.Assert.assertTrue(a.containsAll(e));
    }

    public static void containsItems(JSONArray actual, JSONArray expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsItems(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertTrue(actual.size() >= expect.size());
        org.testng.Assert.assertTrue(actual.containsAll(expect));
    }

    public static void containsItems(String actual, String expect) {
        JSONArray a = JSONArray.parseArray(actual);
        JSONArray e = JSONArray.parseArray(expect);
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsItems(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        org.testng.Assert.assertTrue(a.size() >= e.size());
        org.testng.Assert.assertTrue(a.containsAll(e));
    }

    public static void containsAnyOf(JSONObject actual, JSONObject expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsAnyOf(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        for (Map.Entry<String, Object> entry : expect.entrySet()) {
            assertThat(actual).containsAnyOf(entry);
        }
    }

    public static void containsAnyOf(String actual, String expect) {
        JSONObject a = JSONObject.parseObject(actual);
        JSONObject e = JSONObject.parseObject(expect);
        containsAnyOf(a, e);
    }

    public static void same(JSONObject actual, JSONObject expect) {
        allureAttachment.setName("Assert");
        allureAttachment.setContent("Assert.containsAnyOf(" + actual + "," + expect + ")");
        allureAttachmentService.addAttachment(allureAttachment);
        for (Map.Entry<String, Object> entry : expect.entrySet()) {
            assertThat(actual).containsAnyOf(entry);
            org.testng.Assert.assertEquals(actual.size(), expect.size());
        }
    }

    public static void same(String actual, String expect) {
        JSONObject a = JSONObject.parseObject(actual);
        JSONObject e = JSONObject.parseObject(expect);
        same(a, e);
    }
}