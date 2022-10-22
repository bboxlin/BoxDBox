package com.model;

import java.util.HashMap;
import java.util.Map;

/**
 * HuffmanTable is a table to store the Byte and its HuffMan code.
 * We need a HuffMan Tree to get HuffMan Code.
 *
 */
public class HuffmanTable {
	
	//byte pair to HuffMan code
	private Map<Byte, String> huffmanCodeTable;
	
	
	public HuffmanTable(HuffmanTree huffmanTree) {
		this.huffmanCodeTable = this.buildHuffmanCodes(huffmanTree);
	}
	
	
	private Map<Byte, String> buildHuffmanCodes(HuffmanTree hmTree) {
		Map<Byte, String> hmTable = new HashMap<Byte, String>();
		Node root = hmTree.getRoot();
		this.dfs(root, "", hmTable);
		return hmTable;
	}
	
	private void dfs(Node node, String code, Map<Byte, String> hmTable) {
		if (node.left == null && node.right == null) {
			hmTable.put(node.data, code);
			return;
		}
		if (node.left != null) {
			this.dfs(node.left, code +  "0", hmTable);
		}
		
		if (node.right != null) {
			this.dfs(node.right, code + "1", hmTable);
		}
	}
	
	public void printTable() {
		for (Map.Entry<Byte, String> entry: this.huffmanCodeTable.entrySet()) {
			
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
}
