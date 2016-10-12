object Test {
	def main(args: Array[String]): Unit = {
  
      /* Getting the size of Array */
			print("Enter the list Count :")
			var numCount = Console.readInt()
      
      /* Creating Array of size specified */
			var numList = new Array[Int](numCount)

			/* Taking Input from User */
			for(i <- 0 to (numCount - 1)) {
				print("Enter the number "+ (i + 1) + ": ")
				numList(i) = Console.readInt();
			}
      
			/* Sort the list */
			scala.util.Sorting.quickSort(numList)

			println("\n After sorting the List ... ")
			/* Displaying List to Console */
			for(i <- 0 to (numCount - 1)) {
				println("Number " + (i+1) + "  ------> "+ numList(i) )
			}

			/* Taking element to be searched */
			print("Enter the element to be searched :")
			val num = Console.readInt()

			/* Ask whether to search iteratively or recursively */
			var success = true
			var position = -1
			while(success) {
				println("Enter the tye of search : \n 1. Iterative \n 2. Recursive ")
				var choice = Console.readInt()

				if (choice == 1) {
					/* Call iterative */
					position = iterativeBinarySearch(numList, num)
				}
				else if (choice == 2) {
					/* Call recursive */
					position = iterativeBinarySearch(numList, num)
				}
				else {
					print("Invalid Choice ... ... \n Exiting !!!! \n\n")
					success = false
					scala.util.control.Breaks.break()
				}
				/* Printing the position if found */
				if(position == -1)
					print("Element could not be found !!! \n\n")
				else
					print("Element is found at " + (position +1) + "\n\n")
			}
	}

	/* function: iterativeBinarySearch
	 * Input: List, numberToBeSearched
	 * Output: position of numberToBeSearched if found 
	 * 					else -1
	 */
	def iterativeBinarySearch(numList:Array[Int], numberToBeSearched:Int):Int = {
			var left = 0
			var right = numList.length - 1

			while (left <= right) {
				val mid = left + (right - left) / 2

				/* if the numberToBeSearched is at mid */
				if(numList(mid) == numberToBeSearched)
					return mid

				/* if numberToBeSearched is in left half */
				else if (numList(mid) > numberToBeSearched)
					right = mid - 1

				/* if numberToBeSearched is in right half */
				else
					left = mid + 1
			}
			-1
	}

	/* function: recursiveBinarySearch
	 * Input: List, numberToBeSearched
	 * Output: position of numberToBeSearched if found 
	 * 					else -1
	 */
	def recursiveBinarySearch(numList:Array[Int], left:Int, right:Int, numberToBeSearched:Int): Int = {
			if(left <= right) {
				var mid = left + (right - left) / 2;

				/* if the numberToBeSearched is at mid */
				if(numList(mid) == numberToBeSearched)
					return mid

				/* if numberToBeSearched is in left half */
				else if (numList(mid) > numberToBeSearched)
					return recursiveBinarySearch(numList, left, mid - 1, numberToBeSearched)

				/* if numberToBeSearched is in right half */
				else
					return recursiveBinarySearch(numList, mid + 1, right, numberToBeSearched)
			}
			-1
	}
}
