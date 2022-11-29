package Huffman_Text_Coder_Decoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class CharCounter {
    public static void main(String[] args) {
        String text = "Where there is my why new beginning of entire selfishness text and can you even byte my ass before the lunch time";
        //String text = "where there's a will there's a way";

        TreeMap<Character, Integer> frequencies = countFreq(text);

        System.out.println(frequencies);

        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }

        CodeTreeNode tree = huffman(codeTreeNodes);

        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character ch : frequencies.keySet()) {
            codes.put(ch, tree.getCodeForCharacter(ch, ""));
        }

        System.out.println(codes);

        StringBuilder encoded = new StringBuilder();
        for (int i =0; i< text.length();i++){
            encoded.append(codes.get(text.charAt(i)));
        }

        System.out.println(encoded);

    }

    private static TreeMap<Character, Integer> countFreq(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }

        return freqMap;
    }

    private static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    private static class CodeTreeNode implements Comparable<CodeTreeNode> {

        Character content;
        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;
        }

        public String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {
                    String path = right.getCodeForCharacter(ch, parentPath + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }

}
