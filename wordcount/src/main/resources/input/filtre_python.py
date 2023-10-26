# Ouvrir le fichier d'entrée en mode lecture
with open('purchases.txt', 'r') as input_file:
    # Ouvrir le fichier de sortie en mode écriture
    with open('output.txt', 'w') as output_file:
        total_price = 0.0  # Initialiser la variable pour stocker la somme des prix
        count = 0  # Initialiser le compteur pour le nombre de valeurs
        # Lire chaque ligne du fichier d'entrée
        for line in input_file:
            # Diviser la ligne en colonnes en utilisant la tabulation comme séparateur
            columns = line.strip().split('\t')
            # Vérifier si la 3ème colonne contient "Austin"
            if len(columns) >= 3 and "Austin" in columns[2]:
                # Extraire et écrire la valeur de la 5ème colonne (prix)
                if len(columns) >= 5:
                    price = columns[4]
                    output_file.write(price + '\n')
                    # Ajouter la valeur à la somme des prix
                    total_price += float(price)
                    count += 1

# Calculer la moyenne des valeurs
if count > 0:
    average_price = total_price / count
    print("La moyenne des valeurs extraites est : {:.2f}".format(average_price))
else:
    print("Aucune valeur correspondante trouvée dans le fichier.")

# Fermer les fichiers
input_file.close()
output_file.close()
