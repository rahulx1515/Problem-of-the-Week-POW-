def word_search(matrix, word):
    rows = len(matrix)
    cols = len(matrix[0])

    for row in matrix:
        if word in ''.join(row):
            return True

    for col in range(cols):
        col_str = ''.join(matrix[row][col] for row in range(rows))
        if word in col_str:
            return True

    return False


matrix = [
    ['F', 'A', 'C', 'I'],
    ['O', 'B', 'Q', 'P'],
    ['A', 'N', 'O', 'B'],
    ['M', 'A', 'S', 'S']
]

print(word_search(matrix, "FOAM"))  
print(word_search(matrix, "MASS"))  
print(word_search(matrix, "FACE"))  
