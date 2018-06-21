package model;


public class CircleSimpleList<T> {
	private T info;
	private Node<T> cursor;

	public CircleSimpleList() {
		this.cursor = null;
	}

	public boolean isEmpty() {
		return this.cursor == null;
	}

	/**
	 * inserta al principio de la lista
	 * 
	 * @param info
	 */
	public void insert(T info) {

		if (this.cursor == null) {
			this.cursor = new Node<T>(info, null);
			this.cursor.setNext(this.cursor);
		} else {
			this.cursor.setNext(new Node<T>(info, this.cursor.getNext()));
		}
	}

	/**
	 * retorna un nodo según la posición ingresada
	 * @param number
	 * @return
	 */
	public Node<T> getPosition(int number) {
		Node<T> aux = this.cursor;
		if (this.cursor != null) {
			for (int i = 0; i < number; i++) {
				aux = aux.getNext();
			}
		}
		return aux;
	}

	// public void delete(T info) {
	// if (this.cursor != null) {
	// Node<T> aux = this.cursor;
	// while (aux.getNext() != this.cursor) {
	// if (aux.getInfo().compareTo(info) == 0) {
	// aux.setNext(this.cursor.getNext());
	// this.cursor = null;
	// }
	// aux = aux.getNext();
	// }
	// }
	//
	// }
	//
	// public boolean isSearch(T info) {
	// if (this.cursor != null) {
	// Node<T> aux = this.cursor;
	// while (aux.getNext() != this.cursor) {
	// if (aux.getInfo().compareTo(info) == 0) {
	// return true;
	// }
	// aux = aux.getNext();
	// }
	// }
	// return false;
	// }

	public void add(T info) {
		if (this.cursor == null) {
			this.cursor = new Node<T>(info, null);
			this.cursor.setNext(this.cursor);
		} else {
			Node<T> nodeAux = this.cursor;
			while (nodeAux.getNext() != this.cursor) {
				nodeAux = nodeAux.getNext();
			}
			nodeAux.setNext(new Node<T>(info, this.cursor));
		}
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getCursos() {
		return cursor;
	}

	public void setCursos(Node<T> cursos) {
		this.cursor = cursos;
	}
}
