import { useEffect, useState } from "react";

export default function Widget() {
  const [greeting, setGreeting] = useState("");

  useEffect(() => {
    import("shared").then((shared) => {
      const { hello } = shared.default;
      setGreeting(hello("Kalalau"));
    });
  }, []);

  return (
    <div>
      <header>
        <p>{greeting ? `String from shared: ${greeting}` : "Loading..."}</p>
      </header>
    </div>
  );
}
