package com.mselam.java_interview.data_structures.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static class Result {

        /*
         * Complete the 'insertNodeAtPosition' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER data
         *  3. INTEGER position
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here

            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode insertAt = llist;
            int p = 0;

            while (!Objects.isNull(insertAt) && p < position) {
                prev = insertAt;
                insertAt = prev.next;
                p++;
            }

            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = insertAt;
            if (Objects.isNull(prev)) { // insert at head
                llist = newNode;
            } else {
                prev.next = newNode;
            }
            return llist;
        }

        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
            // Write your code here
            DoublyLinkedListNode insertAt = llist;
            while (!Objects.isNull(insertAt) && !Objects.isNull(insertAt.next) && data > insertAt.data) {
                insertAt = insertAt.next;
            }

            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            if (Objects.isNull(insertAt)) { // list is empty
                llist = newNode;
            } else if (Objects.isNull(insertAt.next) && data >= insertAt.data) { // append at the end of the list
                newNode.prev = insertAt;
                insertAt.next = newNode;
            } else if (Objects.isNull(insertAt.prev) && data < insertAt.data){ // at the head
                newNode.next = insertAt;
                insertAt.prev = newNode;
                llist = newNode;
            }else if(data < insertAt.data) { // insert to the left of insertAt, data == inserAt.data
                DoublyLinkedListNode prev = insertAt.prev;
                newNode.next = insertAt;
                newNode.prev = prev;
                insertAt.prev = newNode;
                prev.next = newNode;
            }else { // insert to the right of insertAt, data == insertAt.data
                DoublyLinkedListNode next = insertAt.next;
                newNode.prev = insertAt;
                newNode.next = next;
                insertAt.next = newNode;
                next.prev = newNode;
            }
            return llist;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("1: SINGLY LINKED LIST INSERT\n2: DOUBLY LINKED SORTED LIST INSERT");
        int choice = scanner.nextInt();
        BufferedWriter bufferedWriter = null;
        switch (choice) {
            case 1:
                bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("SINGLY_OUTPUT_PATH")));

                SinglyLinkedList sllist = new SinglyLinkedList();
                System.out.print("llistCount: ");
                int sllistCount = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < sllistCount; i++) {
                    System.out.print("llistItem: ");
                    int llistItem = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    sllist.insertNode(llistItem);
                }
                System.out.print("data: ");
                int sData = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                System.out.print("position: ");
                int sPosition = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(sllist.head, sData, sPosition);

                printSinglyLinkedList(llist_head, " ", bufferedWriter);
                bufferedWriter.newLine();
                break;
            case 2:
                bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("DOUBLY_OUTPUT_PATH")));
                System.out.print("t: ");
                int t = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int tItr = 0; tItr < t; tItr++) {
                    DoublyLinkedList dllist = new DoublyLinkedList();
                    System.out.print("llistCount: ");
                    int dllistCount = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int i = 0; i < dllistCount; i++) {
                        System.out.print("llistItem: ");
                        int llistItem = scanner.nextInt();
                        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                        dllist.insertNode(llistItem);
                    }
                    System.out.print("data: ");
                    int dData = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    DoublyLinkedListNode llist1 = Result.sortedInsert(dllist.head, dData);

                    printDoublyLinkedList(llist1, " ", bufferedWriter);
                    bufferedWriter.newLine();
                }
                break;
            default:
                break;
        }


        bufferedWriter.close();

        scanner.close();
    }
}

/*
singly:
3
16
13
7
1
2
doubly:
1       t = 1
4       n = 4
1       node data values = 1, 3, 4, 10
3
4
10
5       data = 5
 */