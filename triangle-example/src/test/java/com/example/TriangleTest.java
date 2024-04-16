package com.example;

import static com.example.TriangleType.EQUILATERAL;
import static com.example.TriangleType.INVALID;
import static com.example.TriangleType.ISOSCELES;
import static com.example.TriangleType.SCALENE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {

  @Test
  public void test1() {
    final TriangleType type = Triangle.classify(4, 5, 6);
    assertEquals(SCALENE, type);
  }

  @Test
  public void testInvalid1() {
    final TriangleType type = Triangle.classify(1, 2, 4);
    assertEquals(INVALID, type);
  }


  @Test
  public void testInvalidNeg1() {
    final TriangleType type = Triangle.classify(1, -1, 1);
    assertEquals(INVALID, type);
  }

  @Test
  public void testInvalidNeg3() {
    final TriangleType type = Triangle.classify(1, 1, -1);
    assertEquals(INVALID, type);
  }
    
  @Test
  public void testEquiliteral() {
    final TriangleType type = Triangle.classify(10, 10, 10);
    assertEquals(EQUILATERAL, type);
  }

  @Test
  public void testIsoceles1() {
    final TriangleType type = Triangle.classify(2, 2, 3);
    assertEquals(ISOSCELES, type);
  }


}
