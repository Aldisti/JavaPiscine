import java.util.UUID;

class TransactionsLinkedList implements TransactionsList {
	private TransactionNode	head;
	private int				size;

	public	TransactionsLinkedList() {
		head = null;
		size = 0;
	}

	public void				add(Transaction t) {
		TransactionNode	tmp = new TransactionNode(t);

		if (this.head != null) {
			tmp.setNext(this.head);
			this.head.setBack(tmp);
		}
		this.head = tmp;
		this.size++;
	}

	public void				remove(UUID id) {
		TransactionNode	tmp = this.head;

		while (tmp != null) {
			if (tmp.getData().getIdentifier() == id) {
				if (tmp.getNext() != null) {
					tmp.getNext().setBack(tmp.getBack());
				}
				if (tmp.getBack() != null) {
					tmp.getBack().setNext(tmp.getNext());
				}
				this.size--;
				return ;
			}
			tmp = tmp.getNext();
		}
		throw new TransactionNotFoundException("Transaction not found");
	}

	public Transaction[]	toArray() {
		Transaction		tmp[] = new Transaction[this.size];
		TransactionNode	node = this.head;

		for (int i = 0; i < size; i++) {
			tmp[i] = node.getData();
			node = node.getNext();
		}
		return (tmp);
	}

	public void				print() {
		TransactionNode	tmp = this.head;

		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}
}

