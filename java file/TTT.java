package tic_tac_toe_game;

import java.util.*;
import java.util.HashSet;
import java.util.Scanner;

public class tictactoe {
	static HashSet<Integer> ur_set = new HashSet<Integer>();
	static HashSet<Integer> comp_set = new HashSet<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] g_board = { { "    ", "|", "    ", "|", "    " }, { "----", "|", "----", "|", "----" },
				{ "    ", "|", "    ", "|", "    " }, { "----", "|", "----", "|", "----" },
				{ "    ", "|", "    ", "|", "    " } };

		print_board(g_board);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("+++++++++++++++++++");
			System.out.print("enter values from 1 to 9 number");
			int user_pos = sc.nextInt();

			while (ur_set.contains(user_pos) || comp_set.contains(user_pos)) {
				System.out.println();
				System.out.print("Re-enter values from 1 to 9 number");
				user_pos = sc.nextInt();
			}
			p_holder(g_board, user_pos, "Sai");

			String res = check_winner();
			if (res.length() > 0) {
				System.out.println(res);
				break;
			}

			int cpu_pos = gen_random();
			while (ur_set.contains(cpu_pos) || comp_set.contains(cpu_pos)) {
				cpu_pos = gen_random();
			}
			p_holder(g_board, cpu_pos, "Comp");

			res = check_winner();
			if (res.length() > 0) {
				System.out.println(res);
				break;
			}
		}
	}

	static String check_winner() {
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		HashSet<Integer> c1 = new HashSet<Integer>();
		c1.add(1);
		c1.add(4);
		c1.add(7);
		HashSet<Integer> c2 = new HashSet<Integer>();
		c2.add(2);
		c2.add(5);
		c2.add(8);
		HashSet<Integer> c3 = new HashSet<Integer>();
		c3.add(3);
		c3.add(6);
		c3.add(9);
		HashSet<Integer> d1 = new HashSet<Integer>();
		d1.add(1);
		d1.add(5);
		d1.add(9);
		HashSet<Integer> d2 = new HashSet<Integer>();
		d2.add(3);
		d2.add(5);
		d2.add(7);

		HashSet<HashSet> set = new HashSet<HashSet>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(d1);
		set.add(d2);

		for (HashSet c : set) {
			if (ur_set.containsAll(c))
				return "You won the game";
			else if (comp_set.containsAll(c))
				return "You Lost the game";
		}
		if (ur_set.size() + comp_set.size() == 0)
			return "Draw";

		return "";
	}

	static int gen_random() {
		int max = 9;
		int min = 1;

		int range = max - min + 1;
		int res = (int) (Math.random() * range) + min;
		return res;
	}

	static void print_board(String[][] g_board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < g_board.length; i++) {
			for (int j = 0; j < g_board[0].length; j++) {
				System.out.print(g_board[i][j]);
			}
			System.out.println();
		}
	}

	static void p_holder(String[][] g_board, int pos, String user) {
		String symbol = "Raja";
		if (user.equals("Sai")) {
			symbol = "Raja";
			ur_set.add(pos);
		} else if (user.equals("Comp")) {
			symbol = "Rani";
			comp_set.add(pos);
		}
		switch (pos) {
		case 1:
			g_board[0][0] = symbol;
			break;
		case 2:
			g_board[0][2] = symbol;
			break;
		case 3:
			g_board[0][4] = symbol;
			break;
		case 4:
			g_board[2][0] = symbol;
			break;
		case 5:
			g_board[2][2] = symbol;
			break;
		case 6:
			g_board[2][4] = symbol;
			break;
		case 7:
			g_board[4][0] = symbol;
			break;
		case 8:
			g_board[4][2] = symbol;
			break;
		case 9:
			g_board[4][4] = symbol;
			break;
		default:
			System.out.println("Invalid input");

		}
		print_board(g_board);
	}
}
