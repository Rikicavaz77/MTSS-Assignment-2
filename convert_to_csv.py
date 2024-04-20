import json
import csv

def convert_to_csv(input_file, output_file):
    with open(input_file, 'r') as json_file:
        data = json.load(json_file)

    with open(output_file, 'w', newline='') as csv_file:
        writer = csv.writer(csv_file)
        
        # Scrive l'intestazione del CSV
        writer.writerow(['ID', 'Titolo', 'Stato', 'Creato il', 'Aggiornato il', 'URL'])

        # Itera sugli issue e scrive le informazioni nel CSV
        for issue in data:
            writer.writerow([
                issue['number'],
                issue['title'],
                issue['state'],
                issue['created_at'],
                issue['updated_at'],
                issue['html_url']
            ])

if __name__ == "__main__":
    input_file = 'issues.json'  # Nome del file JSON di input
    output_file = 'issues.csv'  # Nome del file CSV di output

    convert_to_csv(input_file, output_file)
