import json

def parse_json_file(filename):
    with open(filename, 'r') as file:
        # Leggi tutte le righe del file
        lines = file.readlines()
        
        # Rimuovi le righe di metadati HTTP
        json_content = [line for line in lines if line.strip().startswith("{") or line.strip().startswith("[")]

        # Unisci le righe restanti in una stringa JSON
        json_data = ''.join(json_content)

        # Analizza la stringa JSON in un oggetto Python
        data = json.loads(json_data)

        return data

def main():
    # Specifica il percorso del file JSON
    filename = 'issues.json'

    # Utilizzo della funzione per analizzare il file JSON
    try:
        issues_data = parse_json_file(filename)
        print("Contenuto del file JSON:")
        print(issues_data)
    except json.JSONDecodeError:
        print("Errore: il file non è in un formato JSON valido.")

if __name__ == "__main__":
    main()
